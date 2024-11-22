package com.example.spin_bottle.repository

import com.example.spin_bottle.data.ChallengeDao
import com.example.spin_bottle.model.Challenge
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class ChallengeRepository @Inject constructor(
    private val challengeDao: ChallengeDao
) {

    suspend fun saveChallenge(challenge: Challenge) {
        withContext(Dispatchers.IO) {
            challengeDao.saveChallenge(challenge)
        }
    }

    suspend fun getChallengesList(): MutableList<Challenge> {
        return withContext(Dispatchers.IO) {
            challengeDao.getChallengesList().asReversed()
        }
    }

    suspend fun deleteChallenge(challenge: Challenge) {
        withContext(Dispatchers.IO) {
            challengeDao.deleteChallenge(challenge)
        }
    }

    suspend fun updateChallenge(challenge: Challenge) {
        withContext(Dispatchers.IO) {
            challengeDao.updateChallenge(challenge)
        }
    }

}