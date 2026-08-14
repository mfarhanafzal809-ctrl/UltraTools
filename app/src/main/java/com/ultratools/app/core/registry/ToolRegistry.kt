package com.ultratools.app.core.registry

enum class ToolCategory {
    CALCULATE,
    CONVERT,
    DATE_TIME,
    TEXT,
    SCAN_CREATE,
    FILES_IMAGES,
    DEVICE_SENSORS,
    PRODUCTIVITY
}

data class ToolDefinition(
    val id: String,
    val title: String,
    val description: String,
    val category: ToolCategory,
    val keywords: Set<String> = emptySet(),
    val isAvailable: () -> Boolean = { true }
)

object ToolRegistry {

    private val foundationTools = listOf(
        ToolDefinition(
            id = "scientific_calculator",
            title = "Scientific Calculator",
            description = "Advanced calculations and mathematical expressions.",
            category = ToolCategory.CALCULATE,
            keywords = setOf(
                "calculator",
                "math",
                "scientific",
                "calculate"
            )
        ),
        ToolDefinition(
            id = "unit_converter",
            title = "Unit Converter",
            description = "Convert common measurements and digital units.",
            category = ToolCategory.CONVERT,
            keywords = setOf(
                "convert",
                "conversion",
                "units",
                "length",
                "weight",
                "temperature"
            )
        ),
        ToolDefinition(
            id = "age_calculator",
            title = "Age Calculator",
            description = "Calculate exact age and date differences.",
            category = ToolCategory.DATE_TIME,
            keywords = setOf(
                "age",
                "birthday",
                "date",
                "birth"
            )
        ),
        ToolDefinition(
            id = "qr_scanner",
            title = "QR Scanner",
            description = "Scan supported QR codes using the device camera.",
            category = ToolCategory.SCAN_CREATE,
            keywords = setOf(
                "qr",
                "scan",
                "scanner",
                "barcode"
            )
        ),
        ToolDefinition(
            id = "notes",
            title = "Notes",
            description = "Keep useful notes privately on this device.",
            category = ToolCategory.PRODUCTIVITY,
            keywords = setOf(
                "notes",
                "notepad",
                "text",
                "write"
            )
        )
    )

    fun all(): List<ToolDefinition> =
        foundationTools.toList()

    fun byCategory(
        category: ToolCategory
    ): List<ToolDefinition> =
        foundationTools.filter {
            it.category == category && it.isAvailable()
        }
}
