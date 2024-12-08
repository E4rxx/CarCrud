package rgtec.rgtec

data class cruddata(
    var vehicleid: Int = 0,
    var vehiclebrand: String = "",
    var vehiclemodel: String = "",
    var vehicleplate: String = "",
    var vehiclehp: Int = 0,
    var vehicletorque: Int = 0,
    var isdiesel: Boolean = false,
    var ishybrid: Boolean = false,
)
