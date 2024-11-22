package com.example.spin_bottle.di

//import com.example.spin_bottle.data.ChallengeDB
//import com.example.spin_bottle.data.ChallengeDao
import com.example.spin_bottle.utils.Constants.BASE_URL
import com.example.spin_bottle.webservice.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

//    @Singleton
//    @Provides
//    fun provideChallengeDB(@ApplicationContext context: Context): ChallengeDB {
//        return Room.databaseBuilder(
//            context,
//            ChallengeDB::class.java,
//            NAME_BD
//        ).build()
//    }

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

//    @Singleton
//    @Provides
//    fun provideChallengeDao(challengeDB: ChallengeDB): ChallengeDao {
//        return challengeDB.challengeDao()
//    }

}