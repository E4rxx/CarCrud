package rgtec.rgtec

class maincrud {
    val crudarray = arrayOfNulls<cruddata>(size = 5)
    fun updateVehicle() {
        println("Introduzca el ID del vehículo a actualizar")
        val vehicleidupdate = inputIntCrud()
        var found = false
        for (i in crudarray.indices) {
            if (crudarray[i]!!.vehicleid == vehicleidupdate) {
                println("Vehículo encontrado:")
                println(crudarray[i])
                println("Cual es la nueva marca del vehículo? (Actual: ${crudarray[i]!!.vehiclebrand})")
                var vehiclebrand = inputstringUpdateCrud()
                if (vehiclebrand == "") {
                    vehiclebrand = crudarray[i]!!.vehiclebrand
                }
                println("Cual es el nuevo modelo del vehículo? (Actual: ${crudarray[i]!!.vehiclemodel})")
                var vehiclemodel = inputstringUpdateCrud()
                if (vehiclemodel == "") {
                    vehiclemodel = crudarray[i]!!.vehiclemodel
                }
                println("Cual es la nueva matrícula del vehículo? (Actual: ${crudarray[i]!!.vehicleplate})")
                var vehicleplate = inputlicenseplate()
                if (vehicleplate == "") {
                    vehicleplate = crudarray[i]!!.vehicleplate
                }
                println("Cuanta potencia tiene ahora el vehículo? (Actual: ${crudarray[i]!!.vehiclehp})")
                var vehiclehp = inputIntUpdateCrud()
                if (vehiclehp == 0) {
                    vehiclehp = crudarray[i]!!.vehiclehp
                }
                println("Cuanto par tiene ahora el vehículo? (Actual: ${crudarray[i]!!.vehicletorque})")
                var vehicletorque = inputIntUpdateCrud()
                if (vehicletorque == 0) {
                    vehicletorque = crudarray[i]!!.vehicletorque
                }
                println("Es un vehículo diésel? (S/N)(Actual: ${crudarray[i]!!.isdiesel})")
                var isdiesel = inputBooleanCrud()
                if (isdiesel == false) {
                    isdiesel = crudarray[i]!!.isdiesel
                }
                println("Es un vehículo híbrido? (S/N) (Actual: ${crudarray[i]!!.ishybrid})")
                var ishybrid = inputBooleanCrud()
                if (ishybrid == false) {
                    ishybrid = crudarray[i]!!.ishybrid
                }
                crudarray[i] = cruddata(
                    vehicleid = vehicleidupdate,
                    vehiclebrand = vehiclebrand,
                    vehiclemodel = vehiclemodel,
                    vehicleplate = vehicleplate,
                    vehiclehp = vehiclehp,
                    vehicletorque = vehicletorque,
                    isdiesel = isdiesel,
                    ishybrid = ishybrid,
                )
                println("Vehículo actualizado con éxito")
                println(crudarray[i])
                found = true
                return
            }
        }
        if (!found) {
            println("No hay ningún vehículo con ese ID")
            println()
        }
    }
    fun deleteVehicle() {
        println("Introduzca el ID del vehículo a eliminar")
        val vehicleiddelete = inputIntCrud()
        var found = false
        for (i in crudarray.indices) {
            if (crudarray[i]!!.vehicleid == vehicleiddelete) {
                println("Vehículo encontrado:")
                println(crudarray[i])
                crudarray[i] = null
                println("Vehículo eliminado con éxito")
                found = true
                return
            }
        }
        if (!found) {
            println("No hay ningún vehículo con ese ID")
            println()
        }
    }
    fun searchVehicle() {
        println("Introduzca el ID del vehículo a buscar")
        val vehicleidsearch = inputIntCrud()
        var found = false
        for (i in crudarray.indices) {
            if (crudarray[i]!!.vehicleid == vehicleidsearch) {
                println("Vehículo encontrado:")
                println(crudarray[i])
                found = true
                return
            }
        }
        if (!found) {
            println("No hay ningún vehículo con ese ID")
            println()
        }
    }
    fun showAllVehicles() {
        var empty = 0
        for (i in crudarray.indices) {
            if (crudarray[i] == null) {
                empty++
            }
        }
        if (empty == crudarray.size) {
            println("La base de datos está vacía")
        } else {
            println("Vehículos encontrados:")
            for (i in crudarray.indices) {
                if (crudarray[i] != null) {
                    println(crudarray[i])
                }
            }
        }
        println()
    }
    fun insertVehicle() {
        var fillcounter = 0
        for (i in crudarray.indices) {
                if (crudarray[i] != null) {
                    fillcounter++
                } else if (fillcounter == crudarray.size) {
                    println("La base de datos está llena")
                } else {
                    var vehicleidadd = i + 1
                    println("Cual es la marca del vehículo?")
                    var vehiclebrand = inputstringCrud()
                    println("Cual es el modelo del vehículo?")
                    var vehiclemodel = inputstringCrud()
                    println("Cual es la matrícula del vehículo?")
                    var vehicleplate = inputlicenseplate()
                    println("Cuanta potencia tiene el vehículo?")
                    var vehiclehp = inputIntCrud()
                    println("Cuanto par tiene el vehículo?")
                    var vehicletorque = inputIntCrud()
                    println("Es un vehículo diésel? (S/N)")
                    var isdiesel = inputBooleanCrud()
                    println("Es un vehículo híbrido? (S/N)")
                    var ishybrid = inputBooleanCrud()
                    crudarray[i] = cruddata(
                        vehicleid = vehicleidadd,
                        vehiclebrand = vehiclebrand,
                        vehiclemodel = vehiclemodel,
                        vehicleplate = vehicleplate,
                        vehiclehp = vehiclehp,
                        vehicletorque = vehicletorque,
                        isdiesel = isdiesel,
                        ishybrid = ishybrid,
                    )
                    println("Vehículo insertado con éxito")
                    println(crudarray[i])
                    return
            }
        }

    }
    private fun inputIntCrud(): Int {
        var numtypin: Int?
        do {
            numtypin = readln().toIntOrNull()
            if (numtypin == null) {
                println("El campo no puede estar vacío")
            } else if (numtypin < 0) {
                println("El vehiculo no puede tener potencia 0 ni puede ser negativa")
            }
        } while (numtypin == null)
        return numtypin
    }
    private fun inputstringCrud(): String {
        var stringinput: String?
        do {
            stringinput = readln()
            if (stringinput == null) {
                println("El campo no puede estar vacío")
            }
        } while (stringinput == null)
        return stringinput
    }
    private fun inputlicenseplate(): String {
        var licenseplateinput: String?
        var licenseplateregex = Regex("^[0-9]{4}[BCDFGHJKLMNPRSTVWXYZ]{3}$")
        do {
            licenseplateinput = readln().toUpperCase()
            if (licenseplateinput == null) {
                println("El campo no puede estar vacío")
            } else if (!licenseplateregex.matches(licenseplateinput)) {
                println("La matrícula no es válida")
            }
        } while (licenseplateinput == null)
        return licenseplateinput
    }
    private fun inputBooleanCrud(): Boolean {
        var charinput: String
        var selection: Boolean = false
        do {
            charinput = readln().toUpperCase()
            if (charinput == null) {
                println("El campo no puede estar vacío")
            } else if (charinput.length > 1) {
                println("Solo se admite un caracter")
            } else if (charinput != "S" && charinput != "N") {
                println("Solo se admite S para sí o N para no")
            } else if (charinput == "S") {
                selection = true
            } else if (charinput == "N") {
                selection = false
            }
        } while (charinput == null)
        return selection
    }

    private fun inputstringUpdateCrud(): String {
        var stringinput: String
            stringinput = readln()
        return stringinput
    }

    private fun inputIntUpdateCrud(): Int {
        var numtypin: Int?
            numtypin = readln().toIntOrNull() ?: 0
        return numtypin
    }
}