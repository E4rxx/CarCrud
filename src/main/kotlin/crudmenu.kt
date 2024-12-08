package rgtec.rgtec

class crudmenu {
    var exitmenu = false
    fun crudmenudisplay() {
        println("Opciones disponibles:")
        println("1: Insertar coche      2: Eliminar coche")
        println("3: Actualizar coche    4: Buscar coche por ID")
        println("5: Mostrar todos los   0: Salir")
        println("   coches")
    }
    fun inputIntMenu(): Int {
        var numtypin: Int?
        do {
            numtypin = readln().toIntOrNull()
            if (numtypin == null) {
                println("Solo se adminten números enteros")
            }
        } while (numtypin == null)
        return numtypin
    }
    fun selectCrudOptions() {
        val crudMain = maincrud()
        do {
            crudmenudisplay()
            println("Indique la opción:")
            var menuselection = inputIntMenu()
            when (menuselection) {
                1 -> crudMain.insertVehicle()
                2 -> crudMain.deleteVehicle()
                3 -> crudMain.updateVehicle()
                4 -> crudMain.searchVehicle()
                5 -> crudMain.showAllVehicles()
                0 -> {
                    exitmenu = true
                    println("Saliendo del programa...")
                }
                else -> {
                    println("La opción no existe")
                    println()
                }
            }
        } while (!exitmenu)
    }
}