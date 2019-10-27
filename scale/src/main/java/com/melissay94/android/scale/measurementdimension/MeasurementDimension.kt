package com.melissay94.android.scale.measurementdimension

interface MeasurementDimension

object UndefinedUnit: MeasurementDimension

enum class UnitType {
    METRIC,
    IMPERIAL,
    US
}