package com.melissay94.android.scale

import com.melissay94.android.scale.measurementdimension.*

sealed class Measurement<T>(val value: Double, val unit: T?) {
    companion object {

        fun ofLength(amount: Number?, unit: LengthUnit? = LengthUnit.METER): Length? {
            val value = amount?.toDouble() ?: return null

            return when(unit) {
                LengthUnit.METER -> Length(value)
                LengthUnit.PARSEC -> Length(Length.parsecsToMeters(value))
                LengthUnit.LIGHT_YEAR -> Length(Length.lightYearsToMeters(value))
                LengthUnit.ASTRONOMICAL_UNIT -> Length(Length.astronomicalUnitsToMeters(value))
                LengthUnit.NAUTICAL_LEAGUE -> Length(Length.nauticalLeagueToMeters(value))
                LengthUnit.NAUTICAL_MILE -> Length(Length.nauticalMileToMeters(value))
                LengthUnit.MILE -> Length(Length.milesToMeters(value))
                LengthUnit.SCANDINAVIAN_MILE -> Length(Length.scandinavianMilesToMeters(value))
                LengthUnit.FURLONG -> Length(Length.furlongsToMeters(value))
                LengthUnit.CHAIN -> Length(Length.chainsToMeters(value))
                LengthUnit.ROD -> Length(Length.rodsToMeters(value))
                LengthUnit.FATHOM -> Length(Length.fathomsToMeters(value))
                LengthUnit.YARD -> Length(Length.yardsToMeters(value))
                LengthUnit.FEET -> Length(Length.feetToMeters(value))
                LengthUnit.INCHES -> Length(Length.inchesToMeters(value))
                LengthUnit.LINES -> Length(Length.linesToMeters(value))
                LengthUnit.THOU -> Length(Length.thousToMeters(value))
                else -> null
            }
        }

        fun ofLength(amount: Number?, unit: String?): Length? {
            return ofLength(amount, parseLengthUnit(unit))
        }

        private fun parseLengthUnit(unit: String?): LengthUnit? {
            return when(unit) {
                "meters", "meter", "m" -> LengthUnit.METER
                "league", "nautical league" -> LengthUnit.NAUTICAL_LEAGUE
                "nautical mile", "nautical miles" -> LengthUnit.NAUTICAL_MILE
                "smi", "scandinavian mile", "scandinavian miles" -> LengthUnit.SCANDINAVIAN_MILE
                "mile", "miles", "mi" -> LengthUnit.MILE
                "furlong", "furlongs" -> LengthUnit.FURLONG
                "chain", "chains" -> LengthUnit.CHAIN
                "rod", "rods" -> LengthUnit.ROD
                "fathom", "fathoms" -> LengthUnit.FATHOM
                "yard", "yards", "yd" -> LengthUnit.YARD
                "feet", "foot", "ft" -> LengthUnit.FEET
                "inch", "inches", "in" -> LengthUnit.INCHES
                "line", "lines" -> LengthUnit.LINES
                "thou", "thous" -> LengthUnit.THOU
                else -> null
            }
        }
    }

    class Length(private val meters: Double): Measurement<LengthUnit>(meters, LengthUnit.METER) {
        companion object {
            fun parsecsToMeters(amount: Double): Double = amount / PARSECS_IN_METER
            fun lightYearsToMeters(amount: Double): Double = amount / LIGHTYEARS_IN_METER
            fun astronomicalUnitsToMeters(amount: Double): Double = amount / ASTRONOMICAL_UNITS_IN_METER
            fun nauticalLeagueToMeters(amount: Double): Double = amount / NAUTICAL_LEAGUES_IN_METER
            fun nauticalMileToMeters(amount: Double): Double = amount / NAUTICAL_MILES_IN_METER
            fun milesToMeters(amount: Double): Double = amount / MILES_IN_METER
            fun scandinavianMilesToMeters(amount: Double): Double = amount / SCANDINAVIAN_MILES_IN_METER
            fun furlongsToMeters(amount: Double): Double = amount / FURLONGS_IN_METER
            fun chainsToMeters(amount: Double): Double = amount / CHAINS_IN_METER
            fun rodsToMeters(amount: Double): Double = amount / RODS_IN_METER
            fun fathomsToMeters(amount: Double): Double = amount / FATHOMS_IN_METER
            fun yardsToMeters(amount: Double): Double = amount / YARDS_IN_METER
            fun feetToMeters(amount: Double): Double = amount / FEET_IN_METER
            fun inchesToMeters(amount: Double): Double = amount / INCHES_IN_METER
            fun linesToMeters(amount: Double): Double = amount / LINES_IN_METER
            fun thousToMeters(amount: Double): Double = amount / THOUS_IN_METER
        }

        fun toMeters(): Double = meters
        fun toParsecs(): Double = meters * PARSECS_IN_METER
        fun toLightYears(): Double = meters * LIGHTYEARS_IN_METER
        fun toAstronomicalUnits(): Double = meters * ASTRONOMICAL_UNITS_IN_METER
        fun toNauticalLeagues(): Double = meters * NAUTICAL_LEAGUES_IN_METER
        fun toNauticalMiles(): Double = meters * NAUTICAL_MILES_IN_METER
        fun toMiles(): Double = meters * MILES_IN_METER
        fun toScandinavianMiles(): Double = meters * SCANDINAVIAN_MILES_IN_METER
        fun toFurlongs(): Double = meters * FURLONGS_IN_METER
        fun toChains(): Double = meters * CHAINS_IN_METER
        fun toRods(): Double = meters * RODS_IN_METER
        fun toFathoms(): Double = meters * FATHOMS_IN_METER
        fun toYards(): Double = meters * YARDS_IN_METER
        fun toFeet(): Double = meters * FEET_IN_METER
        fun toInches(): Double = meters * INCHES_IN_METER
        fun toLines(): Double = meters * LINES_IN_METER
        fun toThous(): Double = meters * THOUS_IN_METER
    }
}