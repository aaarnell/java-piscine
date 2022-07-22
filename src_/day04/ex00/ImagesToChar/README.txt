# first is to delete directory named 'target'
rm -rf target

# creating the new dir because java don't do it by itself
mkdir target

# set destination directory for class files
javac src/java/edu/school21/printer/*/*.java -d target

#specify where to find user class files
java -classpath ./target edu.school21.printer.app.Program . 0 /Users/wrickard/Desktop/it.bmp