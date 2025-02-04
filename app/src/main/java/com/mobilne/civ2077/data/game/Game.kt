package com.mobilne.civ2077.data.game

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class GameState(
    val full: Boolean = false,
    val inProgress: Boolean = false,
    val waiting: Boolean = false,
)

@IgnoreExtraProperties
data class Players(
    val uid1: String = "",
    val uid2: String = "",
    val uid3: String = "",
)

@IgnoreExtraProperties
data class Player(
    val armyPosition: ArmyPosition = ArmyPosition(),
    val armyPositionChanged: Boolean = false,
    val armySize: Int = 0,
    val basePosition: BasePosition = BasePosition(),
    val dev: Dev = Dev(),
    val gold: Int = 0,
    val nation: String = "",
)

@IgnoreExtraProperties
data class ArmyPosition(
    val x: Int = 0,
    val y: Int = 0
)

@IgnoreExtraProperties
data class BasePosition(
    val x: Int = 0,
    val y: Int = 0
)

@IgnoreExtraProperties
data class Dev(
    val left: Int = 0,
    val right: Int = 0,
)

@IgnoreExtraProperties
data class Turn(
    val number: Int = 0,
    val player1: Boolean = false,
    val player2: Boolean = false,
    val player3: Boolean = false,
)

@IgnoreExtraProperties
data class OnWar(
    val user1: User = User(),
    val user2: User = User(),
    val user3: User = User(),
    val wasWarLastTurn: Boolean = false,
)

@IgnoreExtraProperties
data class User(
    val gold: Int = 0,
    val units: Int = 0,
)
