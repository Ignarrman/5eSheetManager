package com.ignarrman.dnd5esheetmanager.data.local.seed.classes

import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.FeatureEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.ClassEntity
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.ClassFeatureCrossRef
import com.ignarrman.dnd5esheetmanager.data.local.entities.referenceData.classes.MonkProgressionEntity

object MonkReferenceData {

    const val CLASS_ID = 7L

    val features = listOf(
        FeatureEntity(7001L, "Unarmored Defense", "While you are wearing no armor and not wielding a shield, your AC equals 10 + your Dexterity modifier + your Wisdom modifier."),
        FeatureEntity(7002L, "Martial Arts", "Your practice of martial arts gives you mastery of combat styles that use unarmed strikes and monk weapons."),
        FeatureEntity(7003L, "Ki", "Your training allows you to harness the mystical energy of ki."),
        FeatureEntity(7004L, "Unarmored Movement", "Your speed increases while you are not wearing armor or wielding a shield."),
        FeatureEntity(7005L, "Monastic Tradition", "You commit yourself to a monastic tradition."),
        FeatureEntity(7006L, "Deflect Missiles", "You can use your reaction to deflect or catch the missile when you are hit by a ranged weapon attack."),
        FeatureEntity(7007L, "Slow Fall", "You can use your reaction to reduce any falling damage you take."),
        FeatureEntity(7008L, "Extra Attack", "You can attack twice, instead of once, whenever you take the Attack action on your turn."),
        FeatureEntity(7009L, "Stunning Strike", "You can interfere with the flow of ki in an opponent's body."),
        FeatureEntity(7010L, "Evasion", "Your instinctive agility lets you dodge out of the way of certain area effects."),
        FeatureEntity(7011L, "Stillness of Mind", "You can use your action to end one effect on yourself causing you to be charmed or frightened."),
        FeatureEntity(7012L, "Purity of Body", "Your mastery of the ki flowing through you makes you immune to disease and poison."),
        FeatureEntity(7013L, "Tongue of the Sun and Moon", "You understand all spoken languages."),
        FeatureEntity(7014L, "Diamond Soul", "Your mastery of ki grants you proficiency in all saving throws."),
        FeatureEntity(7015L, "Timeless Body", "Your ki sustains you so that you suffer none of the frailty of old age."),
        FeatureEntity(7016L, "Empty Body", "You can use your action to spend ki points to become invisible and gain resistance to all damage but force damage."),
        FeatureEntity(7017L, "Perfect Self", "When you roll for initiative and have no ki points remaining, you regain 4 ki points.")
    )

    val featureRelations = listOf(
        ClassFeatureCrossRef(CLASS_ID, 7001L, 1),
        ClassFeatureCrossRef(CLASS_ID, 7002L, 1),
        ClassFeatureCrossRef(CLASS_ID, 7003L, 2),
        ClassFeatureCrossRef(CLASS_ID, 7004L, 2),
        ClassFeatureCrossRef(CLASS_ID, 7005L, 3),
        ClassFeatureCrossRef(CLASS_ID, 7006L, 3),
        ClassFeatureCrossRef(CLASS_ID, 7007L, 4),
        ClassFeatureCrossRef(CLASS_ID, 7008L, 5),
        ClassFeatureCrossRef(CLASS_ID, 7009L, 5),
        ClassFeatureCrossRef(CLASS_ID, 7010L, 7),
        ClassFeatureCrossRef(CLASS_ID, 7011L, 7),
        ClassFeatureCrossRef(CLASS_ID, 7012L, 10),
        ClassFeatureCrossRef(CLASS_ID, 7013L, 13),
        ClassFeatureCrossRef(CLASS_ID, 7014L, 14),
        ClassFeatureCrossRef(CLASS_ID, 7015L, 15),
        ClassFeatureCrossRef(CLASS_ID, 7016L, 18),
        ClassFeatureCrossRef(CLASS_ID, 7017L, 20)
    )

    val progression = (1..20).map { level ->
        MonkProgressionEntity(
            level = level,
            martialArtsDie = when {
                level <= 4 -> 4
                level <= 10 -> 6
                level <= 16 -> 8
                else -> 10
            },
            kiPoints = if (level == 1) 0 else level
        )
    }
}