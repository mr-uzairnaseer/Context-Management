# Context - Personal Life Hub

Context is an offline-first Android application that organizes your digital life into meaningful contexts (Work, Trip, etc.).

## Setup Instructions

### 1. Android Project Setup
1. Open this project in Android Studio.
2. Sync Gradle with Project Files.
3. This project uses **Room** for local storage and **WorkManager** for background sync.

### 2. Supabase Backend Setup
To enable the backend features (Sync, Auth, Context Matching), you need a free Supabase project.

1. **Create a Project**: Go to [supabase.com](https://supabase.com) and create a new project.
2. **Database Schema**:
   - Go to the **SQL Editor** in Supabase.
   - Run the contents of the `schema.sql` file provided in the artifacts.
   - This will create `contexts`, `items` tables and enable vector search.
3. **Edge Functions** (Optional for Context Matching):
   - Only needed if you want AI context suggestions.
   - Use the `edge_functions.ts` code to deploy a Supabase function named `match_contexts`.

### 3. Application Configuration
1. Open `app/src/main/java/com/itechon/context/data/remote/SupabaseClient.kt`.
2. Replace the placeholders with your Supabase credentials:
   ```kotlin
   private const val SUPABASE_URL = "https://your-project-ref.supabase.co"
   private const val SUPABASE_KEY = "your-anon-key"
   ```

### 4. Build & Run
- Connect an Android device or Emulator (API 26+).
- Run the app via Android Studio or `./gradlew installDebug`.

## Features
- **Contexts**: Create and manage life contexts.
- **Timeline**: Add notes to contexts (Photos/Audio support infrastructure in place).
- **Offline-First**: Data works offline and syncs when online.
- **Search**: Architecture ready for vector search.

## Tech Stack
- **Languages**: Kotlin
- **UI**: Jetpack Compose, Material 3
- **Architecture**: MVVM, Repository Pattern
- **Local Data**: Room Database
- **Remote Data**: Supabase (PostgreSQL, GoTrue, Storage)
- **Sync**: WorkManager
