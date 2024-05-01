fun main() {
    val version1 = "1.01"
    val version2 = "1.001"
    //########## Output: 0

    //val version1 = "1.0"
    //val version2 = "1.0.0"
    //########## Output: 0

    //val version5 = "0.1"
    //val version6 = "1.1"
    //########## Output: -1
    println("Input: version1 = $version1 version2 = $version2")
    val bValidVersion = checkValidVersion(version1, version2)
    if(bValidVersion){
        val nOutput = compareVersion(version1, version2)
    	println("Output: $nOutput")
    }
    else
    	println("Invalid version number!!")
}

fun compareVersion(version1: String, version2: String): Int {
    val ver1 = version1.split('.')
    val ver2 = version2.split('.')

    val maxLength = maxOf(ver1.size, ver2.size)

    for (index in 0 until maxLength) {
        var verNumber1 = 0
        var verNumber2 = 0
        
        if(index < ver1.size)
        	verNumber1 = ver1[index].toInt()
        if(index < ver2.size)
        	verNumber2 = ver2[index].toInt()

		if (verNumber1 < verNumber2) 
        	return -1
        if (verNumber1 > verNumber2) 
        	return 1
    }
    return 0
}

fun checkValidVersion(version1: String, version2: String): Boolean {
    var bValidVersion = true
    val ver1 = version1.split('.')
    val ver2 = version2.split('.')
    //Check version length
    if(ver1.size !in 1..500 || ver2.size !in 1..500)
    	bValidVersion = false
    //Check version1 contain
    if (version1.all { it in '0'..'9' || it == '.' })
    	//Nothing
    else
    	bValidVersion = false
    //Check version2 contain
    if (version2.all { it in '0'..'9' || it == '.' })
    	//Nothing
    else
    	bValidVersion = false
    
    return bValidVersion
}