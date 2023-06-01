package com.alcohol.dionysus.security;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TokenAuthenticationFilter extends OncePerRequestFilter {
	private static final Logger LOG = LoggerFactory.getLogger(TokenAuthenticationFilter.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		try {
			String idToken = getTokenFromRequest(request);

			FirebaseToken decodedToken = null;
			try {
				decodedToken = FirebaseAuth.getInstance().verifyIdToken(idToken);
			} catch (FirebaseAuthException e) {
				LOG.error("Firebase Exception {}", e.getLocalizedMessage());
			}
			if (decodedToken != null) {
				CustomPrincipal customPrincipal = new CustomPrincipal();
				customPrincipal.setUid(decodedToken.getUid());
				customPrincipal.setPhoneNumber((String) decodedToken.getClaims().get("phone_number"));
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
						customPrincipal, decodedToken, null);
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
			filterChain.doFilter(request, response);
		} catch (Exception ex) {
			logger.error("Could not set user authentication in security context", ex);
		}
	}

	private String getTokenFromRequest(HttpServletRequest request) {
		String token = null;
		Cookie cookieToken = WebUtils.getCookie(request, "token");
		if (cookieToken != null) {
			token = cookieToken.getValue();
		} else {
			String bearerToken = request.getHeader("Authorization");
			if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
				token = bearerToken.substring(7);
			}
		}
		return token;
	}
}
