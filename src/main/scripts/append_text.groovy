/**
 *  © Copyright IBM Corporation 2014, 2016.
 *  This is licensed under the following license.
 *  The Eclipse Public 1.0 License (http://www.eclipse.org/legal/epl-v10.html)
 *  U.S. Government Users Restricted Rights:  Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.
 */

def workDir = new File('.').canonicalFile
def props = new Properties()
def inputPropsFile = new File(args[0])
try {
    inputPropsStream = new FileInputStream(inputPropsFile)
    props.load(inputPropsStream)
}
catch (IOException e) {
    throw new RuntimeException(e)
}

//final def filePath = "C:/test/test.txt"
//final def text = "appended text"
//final def startOnNewLine = false

def filePath = props['filePath'];
def text = props['text'];
def startOnNewLine = props['startOnNewLine'].toBoolean()

println "File path: $filePath"
println "Text: $text"
println "Start On New Line: $startOnNewLine"

File file = new File(filePath)
if (startOnNewLine == true) {
	file.append("\n" + text)
} else {
	file.append(text)
}

println "Appended text to file"

System.exit(0)
