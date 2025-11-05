package ru.kvmsoft.features.profile.imp.mapper

import ru.kvmsoft.base.storage.model.Profile
import ru.kvmsoft.base.storage.model.UserAchievement
import ru.kvmsoft.features.profile.api.model.AchievementDomain
import ru.kvmsoft.features.profile.api.model.DeleteProfileResponseDomain
import ru.kvmsoft.features.profile.api.model.ProfileDomain
import ru.kvmsoft.features.profile.api.model.UpdateEmailResponseDomain
import ru.kvmsoft.features.profile.api.model.UpdateNameResponseDomain
import ru.kvmsoft.features.profile.api.model.UpdatePhotoResponseDomain
import ru.kvmsoft.features.profile.imp.model.response.AchievementResponse
import ru.kvmsoft.features.profile.imp.model.response.DeleteProfileResponse
import ru.kvmsoft.features.profile.imp.model.response.UpdateEmailResponse
import ru.kvmsoft.features.profile.imp.model.response.UpdateNameResponse
import ru.kvmsoft.features.profile.imp.model.response.UpdatePhotoResponse


object Mapper {

    private fun map(userAchievements: List<UserAchievement>):List<AchievementDomain>{
        val list = ArrayList<AchievementDomain>()
        userAchievements.forEach {userAchievement ->
            list.add(
                AchievementDomain(
                achievementId = userAchievement.achievementId,
                achievementName = userAchievement.achievementName,
                achievementDescription = userAchievement.achievementDescription,
                achievementLevel = userAchievement.achievementLevel
            )
            )
        }
        return list
    }

    fun mapToProfileDomain(profile: Profile): ProfileDomain {
        return ProfileDomain(
            userId = profile.userId,
            userName = profile.userName,
            userEmail = profile.userEmail,
            userPhotoBase64 = profile.userPhotoBase64,
            userStatus = profile.userStatus,
            userType = profile.userType,
            userAchievements = map(profile.userAchievements),
            userPurchasedProfessions = profile.userPurchasedProfessions,
            errorMsg = ""
        )
    }

    private fun map(userAchievments: List<AchievementDomain>, userId: Int):List<UserAchievement>{
        val list = ArrayList<UserAchievement>()
        userAchievments.forEach {userAchievement ->
            list.add(
                UserAchievement(
                    achievementId = userAchievement.achievementId,
                    userId = userId,
                    achievementName = userAchievement.achievementName,
                    achievementDescription = userAchievement.achievementDescription,
                    achievementLevel = userAchievement.achievementLevel
                )
            )
        }
        return list
    }
    fun mapFromProfileDomain(profile: ProfileDomain, base64Photo: String): Profile{
        return Profile(
            userId = profile.userId,
            userName = profile.userName,
            userEmail = profile.userEmail,
            userType = profile.userType,
            userStatus = profile.userStatus,
            userAchievements = map(profile.userAchievements, userId = profile.userId),
            userPhotoBase64 = base64Photo,
            userPurchasedProfessions = profile.userPurchasedProfessions
        )
    }

    fun map(response: AchievementResponse): AchievementDomain{
        return AchievementDomain(
            achievementId = response.achievementId,
            achievementName = response.achievementName,
            achievementDescription = response.achievementDescription,
            achievementLevel = response.achievementLevel
        )
    }

    fun mapToEmailResponseDomain(response: UpdateEmailResponse): UpdateEmailResponseDomain {
        return UpdateEmailResponseDomain(
            success = response.success,
            errorMsg = response.errorMsg
        )
    }

    fun mapToNameResponseDomain(response: UpdateNameResponse): UpdateNameResponseDomain {
        return UpdateNameResponseDomain(
            success = response.success,
            errorMsg = response.errorMsg
        )
    }

    fun mapToPhotoResponseDomain(response: UpdatePhotoResponse): UpdatePhotoResponseDomain {
        return UpdatePhotoResponseDomain(
            success = response.success,
            errorMsg = response.errorMsg
        )
    }

    fun mapToDeleteProfileResponseDomain(response: DeleteProfileResponse): DeleteProfileResponseDomain {
        return DeleteProfileResponseDomain(
            success = response.success,
            errorMsg = response.errorMsg
        )
    }
}