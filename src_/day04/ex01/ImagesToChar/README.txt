# first is to delete directory named 'target'
rm -rf target

# creating the new dir because java don't do it by itself
mkdir target

# set destination directory for class files
javac src/java/edu/school21/printer/*/*.java -d target

# copy resources to destination directory
cp -rf ./src/resources ./target

# create JAR archive
# jar cfm ./target/images-to-chars-printer.jar ./src/java/edu/school21/printer/manifest.txt -C ./target .
jar cfm ./target/images-to-chars-printer.jar ./src/manifest.txt -C ./target .

# set rights
chmod 777 ./target/images-to-chars-printer.jar

java -jar ./target/images-to-chars-printer.jar . 0
