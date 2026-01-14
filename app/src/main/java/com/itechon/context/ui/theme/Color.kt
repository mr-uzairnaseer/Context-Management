package com.itechon.context.ui.theme

import androidx.compose.ui.graphics.Color

// ==========================================
// Base Palette (Primitive Colors)
// ==========================================

// Brand Colors
val BrandYellow = Color(0xFFFFD600) // Material Yellow A700 - Impact/Accent
val BrandYellowDark = Color(0xFFC7A500) // For pressed states

// Neutral Palette (Greyscale)
val White = Color(0xFFFFFFFF)
val Grey50 = Color(0xFFF9FAFB)
val Grey100 = Color(0xFFF3F4F6)
val Grey200 = Color(0xFFE5E7EB)
val Grey300 = Color(0xFFD1D5DB)
val Grey400 = Color(0xFF9CA3AF)
val Grey500 = Color(0xFF6B7280)
val Grey600 = Color(0xFF4B5563)
val Grey700 = Color(0xFF374151)
val Grey800 = Color(0xFF1F2937)
val Grey900 = Color(0xFF111827) // Very Dark (almost black)
val Black = Color(0xFF000000)

// Semantic Colors
val ErrorRed = Color(0xFFDC2626) // Red 600
val SuccessGreen = Color(0xFF16A34A) // Green 600

// ==========================================
// Light Theme Tokens
// ==========================================
val LightPrimary = Black // High professionalism
val LightOnPrimary = White
val LightPrimaryContainer = BrandYellow // Yellow Accents for Containers
val LightOnPrimaryContainer = Black
val LightSecondary = Grey700
val LightOnSecondary = White
val LightTertiary = BrandYellow
val LightOnTertiary = Black
val LightError = ErrorRed
val LightOnError = White
val LightBackground = White
val LightOnBackground = Black
val LightSurface = Grey50 // Slightly off-white for surface differentiation
val LightOnSurface = Black
val LightSurfaceVariant = Grey200
val LightOnSurfaceVariant = Grey700
val LightOutline = Grey400

// ==========================================
// Dark Theme Tokens
// ==========================================
val DarkPrimary = White
val DarkOnPrimary = Black
val DarkPrimaryContainer = BrandYellow
val DarkOnPrimaryContainer = Black
val DarkSecondary = Grey300
val DarkOnSecondary = Black
val DarkTertiary = BrandYellow
val DarkOnTertiary = Black
val DarkError = Color(0xFFEF4444) // Red 500 (lighter for dark mode)
val DarkOnError = Black
val DarkBackground = Color(0xFF121212) // Material Dark
val DarkOnBackground = White
val DarkSurface = Color(0xFF1E1E1E) // Elevated Surface
val DarkOnSurface = White
val DarkSurfaceVariant = Grey800 // Darker Variant
val DarkOnSurfaceVariant = Grey300
val DarkOutline = Grey600

// ==========================================
// Gradient Tokens (Adapts to Theme in UI)
// ==========================================
val GradientStartLight = White
val GradientEndLight = Grey100

val GradientStartDark = Color(0xFF1E1E1E)
val GradientEndDark = Color(0xFF121212)