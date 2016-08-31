/**
 *  © Copyright IBM Corporation 2014, 2016.
 *  This is licensed under the following license.
 *  The Eclipse Public 1.0 License (http://www.eclipse.org/legal/epl-v10.html)
 *  U.S. Government Users Restricted Rights:  Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.
 */

final def workDir = new File('.').canonicalFile
final def props = new Properties()
final def inputPropsFile = new File(args[0])
try {
    inputPropsStream = new FileInputStream(inputPropsFile)
    props.load(inputPropsStream)
}
catch (IOException e) {
    throw new RuntimeException(e)
}


//final def filePath = 'C:/test/'


final def filePath = props['filePath']
final def searchString = props['searchString']

println "Checking file ${filePath} for searching string : ${searchString}"

File file = new File(filePath)

if (!file.exists()) {
	println "File does not exist"
	System.exit(-1)
}

if (file.text.contains(searchString)) {
	println "Match found"
} else {
	println "Match not found"
	System.exit(-1)
}

System.exit(0)
