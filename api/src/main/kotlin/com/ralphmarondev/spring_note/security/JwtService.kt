package com.ralphmarondev.spring_note.security

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Service
import java.util.*
import javax.crypto.SecretKey

@Service
class JwtService {

    private val accessKey = Keys.secretKeyFor(SignatureAlgorithm.HS256)
    private val refreshKey = Keys.secretKeyFor(SignatureAlgorithm.HS256)

    private val accessTokenExpiration = 1000 * 60 * 15 // 15 mins
    private val refreshTokenExpiration = 1000L * 60 * 60 * 24 * 7 // 7 days

    fun generateAccessToken(email: String): String {
        val now = Date()
        val expiry = Date(now.time + accessTokenExpiration)

        return Jwts.builder()
            .setSubject(email)
            .setIssuedAt(now)
            .setExpiration(expiry)
            .signWith(accessKey)
            .compact()
    }

    fun generateRefreshToken(email: String): String {
        val now = Date()
        val expiry = Date(now.time + refreshTokenExpiration)

        return Jwts.builder()
            .setSubject(email)
            .setIssuedAt(now)
            .setExpiration(expiry)
            .signWith(refreshKey)
            .compact()
    }

    fun extractEmailFromAccess(token: String): String? {
        return extractClaim(token, accessKey)
    }

    fun extractEmailFromRefresh(token: String): String? {
        return extractClaim(token, refreshKey)
    }

    private fun extractClaim(token: String, key: SecretKey): String? {
        return try {
            Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .body.subject
        } catch (e: Exception) {
            null
        }
    }

    fun isAccessTokenValid(token: String, email: String): Boolean {
        return extractEmailFromAccess(token) == email && !isExpired(token, accessKey)
    }

    fun isRefreshTokenValid(token: String, email: String): Boolean {
        return extractEmailFromRefresh(token) == email && !isExpired(token, refreshKey)
    }

    private fun isExpired(token: String, key: SecretKey): Boolean {
        return try {
            val expiration = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .body.expiration
            expiration.before(Date())
        } catch (e: Exception) {
            true
        }
    }


}