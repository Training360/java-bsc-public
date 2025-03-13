package stringmethods.filename;

public class FileName {

    public char findLastCharacter(String str) {
        str = str.trim();

        return str.charAt(str.length() - 1);
    }

    public String findFileExtension(String fileName) {
        fileName = fileName.trim();
        int index = fileName.lastIndexOf('.') + 1;

        return fileName.substring(index);
    }

    public boolean identifyFilesByExtension(String extension, String fileName) {
        fileName = fileName.trim();
        extension = extension.trim();

        return fileName.endsWith(extension);
    }

    public boolean compareFilesByName(String searchedFileName, String actualFileName) {

        return searchedFileName.trim().equalsIgnoreCase(actualFileName.trim());
    }

    public String changeExtensionToLowerCase(String fileName) {
        fileName = fileName.trim();
        int index = fileName.lastIndexOf('.');
        String namePart = fileName.substring(0, index);
        String extension = fileName.substring(index).toLowerCase();

        return namePart + extension;
    }

    public String replaceStringPart(String fileName, String present, String target) {
        if (fileName.contains(present)) {
            return fileName.replace(present, target);
        }

        return fileName;
    }
}
