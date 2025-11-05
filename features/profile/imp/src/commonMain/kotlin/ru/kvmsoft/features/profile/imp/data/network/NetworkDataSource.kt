package ru.kvmsoft.features.profile.imp.data.network

import ru.kvmsoft.features.profile.api.model.AchievementDomain
import ru.kvmsoft.features.profile.api.model.DeleteProfileResponseDomain
import ru.kvmsoft.features.profile.api.model.ProfileDomain
import ru.kvmsoft.features.profile.api.model.UpdateEmailResponseDomain
import ru.kvmsoft.features.profile.api.model.UpdateNameResponseDomain
import ru.kvmsoft.features.profile.api.model.UpdatePhotoResponseDomain
import ru.kvmsoft.features.profile.imp.mapper.Mapper

class NetworkDataSource(private val api: ProfileApi){

    suspend fun getProfile(): ProfileDomain {
        val result = api.getProfile()
        val userAchievements = ArrayList<AchievementDomain>()
        result.userAchievements.forEach { achievement->
            userAchievements.add(Mapper.map(achievement))
        }
        return ProfileDomain(
            userId = result.userId,
            userName = result.userName,
            userType = result.userType,
            userStatus = result.userStatus,
            userEmail = result.userEmail,
            userPhotoBase64 = result.userPhoto,
            userPurchasedProfessions = result.userPurchasedProfessions,
            userAchievements = userAchievements,
            errorMsg = result.errorMsg
        )
   }

    suspend fun updateName(name: String): UpdateNameResponseDomain {
        return Mapper.mapToNameResponseDomain(api.updateName(name = name))
    }

    suspend fun updateEmail(email: String): UpdateEmailResponseDomain {
        return Mapper.mapToEmailResponseDomain(api.updateEmail(email = email))
    }

    suspend fun updatePhoto(photo: ByteArray): UpdatePhotoResponseDomain {
        return Mapper.mapToPhotoResponseDomain(api.updatePhoto(photo = photo))
    }

    suspend fun deleteProfile(): DeleteProfileResponseDomain {
        return Mapper.mapToDeleteProfileResponseDomain(api.deleteProfile())
    }
}