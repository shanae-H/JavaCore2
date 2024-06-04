import java.io.*;
import java.util.*;

public class ArrayTask implements Serializable {
    String [] lyricArray;
    List <String> lyricList;
    String lyrics = "In the town where I was born\n" +
            "Lived a man who sailed to sea\n" +
            "And he told us of his life\n" +
            "In the land of submarines\n" +
            "\n" +
            "So we sailed up to the sun\n" +
            "'Til we found the sea of green\n" +
            "And we lived beneath the waves\n" +
            "In our yellow submarine\n" +
            "\n" +
            "We all live in a yellow submarine\n" +
            "Yellow submarine, yellow submarine\n" +
            "We all live in a yellow submarine\n" +
            "Yellow submarine, yellow submarine\n" +
            "\n" +
            "And our friends are all aboard\n" +
            "Many more of them live next door\n" +
            "And the band begins to play\n" +
            "\n" +
            "We all live in a yellow submarine\n" +
            "Yellow submarine, yellow submarine\n" +
            "We all live in a yellow submarine\n" +
            "Yellow submarine, yellow submarine\n" +
            "\n" +
            "Full speed ahead, Mr. Boatswain, full speed ahead !\n" +
            "Full speed it is, Sergeant !\n" +
            "Cut the cable, drop the cable !\n" +
            "Aye-aye, sir, aye-aye !\n" +
            "Captain, Captain !\n" +
            "\n" +
            "As we live a life of ease ( a life of ease )\n" +
            "Everyone of us ( everyone of us ) has all we need ( has all we need )\n" +
            "Sky of blue ( sky of blue ) and sea of green ( sea of green )\n" +
            "In our yellow ( in our yellow ) submarine ( submarine, ah-ha )\n" +
            "\n" +
            "We all live in a yellow submarine\n" +
            "Yellow submarine, yellow submarine\n" +
            "We all live in a yellow submarine\n" +
            "Yellow submarine, yellow submarine\n" +
            "\n" +
            "We all live in a yellow submarine\n" +
            "Yellow submarine, yellow submarine\n" +
            "We all live in a yellow submarine\n" +
            "Yellow submarine, yellow submarine\n";

    public ArrayTask(){
        removeAndConvertLyricsToArray();
    }

    //Part 1- #1,2,3,4
    public void removeAndConvertLyricsToArray(){
        lyrics = lyrics.replace(",", " ");
        lyrics = lyrics.replace("\n", " ");
        lyrics = lyrics.toLowerCase();
        lyricArray= lyrics.split(" ");
    }

    //Part 1 #5
    public void countWordInArray (){
        int count=0;
        for (String s: lyricArray){
            if(s.equalsIgnoreCase("submarine")){
            count++;
            }
        }
        System.out.println("Using a String Array, the word submarine was counted "+ count+" through out the lyrics");
    }

    //Part 2- #1, 2
    public void removeDuplicatesAndSort() {
        lyricList = Arrays.asList(lyricArray);
        int count = Collections.frequency(lyricList, "submarine");
        System.out.println("Using a List of type String, the word submarine was counted " + count + " through out the lyrics");

        lyricList = new LinkedList<String>(lyricList.stream().distinct().toList());
        System.out.println("All duplicated words have been removed \n" + lyricList);

        lyricList.sort(Comparator.comparingInt(String::length));
    }

    //Part 3 - #1,2,3
    public void removeSpecificWords() {
        ListIterator<String> iter = lyricList.listIterator();
        while (iter.hasNext()) {
            String word = iter.next();
            if (word.contains("yellow") || word.contains("submarine")) {
                iter.remove();
            }
        }
        System.out.println("The words 'yellow' and 'submarine' have been removed \n" + lyricList);
    }

    //Part 4 #1
    public void serializeLyricsToFile() {
        try (FileOutputStream fileOut = new FileOutputStream("yellow submarine.txt");
             ObjectOutputStream objOut = new ObjectOutputStream(fileOut);) {
            objOut.writeObject(lyrics);
            objOut.close();
            fileOut.close();
            System.out.println("Lyrics to the Yellow Submarine has been saved.");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    // Part 4 #2
    public void readLyricsFromFile() {
        try (FileInputStream fileIn = new FileInputStream("yellow submarine.txt");
             ObjectInputStream objIn = new ObjectInputStream(fileIn)) {
            String lyricsFromFile = (String) objIn.readObject();
            fileIn.close();
            objIn.close();
            System.out.println("Output from yellow submarine file: " + lyricsFromFile);
        } catch (IOException | ClassNotFoundException io) {
            io.printStackTrace();
        }
    }

    //Part 4 #3
    public void useCustomException() throws BeatlesException{
        lyricList.add("beatles");
        if (lyricList.contains("beatles")){
            throw new BeatlesException("Word found");
        }else{
            System.out.println("Did not find the word beatles");
        }
    }

    //Part 4 #4
    public void findRandomString(String randomStr) throws BeatlesException{
        try (FileInputStream fileIn = new FileInputStream("yellow submarine.txt");
             ObjectInputStream objIn = new ObjectInputStream(fileIn)) {
            String lyricsFromFile = (String) objIn.readObject();
            fileIn.close();
            objIn.close();
            randomStr= randomStr.toLowerCase();
            if (lyricsFromFile.contains(randomStr)){
                System.out.println("\""+randomStr+"\" has been found in the Yellow Submarine lyrics");
            }else{
                throw new BeatlesException("Random string cannot be found");
            }
        } catch (IOException | ClassNotFoundException io) {
            io.printStackTrace();
        }
    }

    public static void main(String [] args){
        ArrayTask at= new ArrayTask();
        at.countWordInArray();
        at.removeDuplicatesAndSort();
        at.removeSpecificWords();
        at.serializeLyricsToFile();
        at.readLyricsFromFile();
        try{
            at.useCustomException();
            at.findRandomString("he told us of his life");
        }catch(BeatlesException beatle){
            beatle.printStackTrace();
        }
    }
}


