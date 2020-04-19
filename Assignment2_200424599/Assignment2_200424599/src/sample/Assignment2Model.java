package sample;

import java.io.IOException;
import java.util.ArrayList;

public class Assignment2Model {
    private String word;
    private static int total=0;
    private int bagC=0;
    public String message = "Let's Start";
    private static ArrayList<String> myList = new ArrayList<String>();
    private int[] points = {1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};
    private static int[] myBeg =  {9,2,2,4,12,2,3,2,8,1,1,4,2,6,8,2,1,6,4,6,4,2,2,1,2,1};
    private char[] chars = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

    public Assignment2Model(String word) throws Exception
    {
        if(setWord(word.toUpperCase()) == true && checkRepetWorld(word.toUpperCase()) == true) {
            if(begCount(word.toUpperCase()) == true) {
                this.word = word.toUpperCase();
                myList.add(word.toUpperCase());
                message = "Word added.";
                countScore();
                getList();
            }
        }
    }

    public String getScore() {
        return String.valueOf(total);
    }

    public void countScore() {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            for (int j = 0; j < chars.length; j++) {
                if (c == chars[j]) {
                    total = total + points[j];
                }
            }
        }
    }
    public boolean setWord(String word) {
        int count=0;
        if(word.length() >= 2 && word.length() <=8)
        {
            for (int i = 0 ; i<word.length(); i++)
            {
                char v = word.charAt(i);
                if (v == 'A' || v == 'E' || v == 'I' || v == 'O' || v == 'U' || v == 'Y')
                {
                    count++;
                }
            }

            if (count == 0)
            {
                message = "There should be at least one vowel in the word.";
                return false;
            }
            else
            {
                count=0;
                return true;
            }
        }
        else
        {
            message = "Word length should be in between 2 to 8 characters .";
            return false;
        }
    }

    public boolean checkRepetWorld(String word)
    {
        int count = 0;
        for (String ch : myList)
        {
            if(ch.compareTo(word) == 0)
            {
                count++;
            }
        }
        if (count == 0)
        {
            return true;
        }
        else
        {
            message =  word + " It is already used.";
            return false;
        }
    }

    public boolean begCount(String word)
    {

        for (int i = 0; i < word.length(); i++) {
            char x = word.charAt(i);
            for (int j = 0; j < chars.length; j++) {
                if (x == chars[j]) {
                    if (myBeg[j] > 0) {
                        myBeg[j]--;
                        bagC++;
                    } else {
                        for (int k=0;k < bagC; k++)
                        {
                            char restore = word.charAt(k);
                            for (int g=0; g<chars.length;g++)
                            {
                                if (restore == chars[g])
                                {
                                    myBeg[g]++;
                                }
                            }
                        }
                        bagC =0;
                        message = "No more " + chars[j] + " left in the bag. :(";
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public String setTitle()
    {
        return message;
    }

    private String wordList = "";
    public void getList()
    {

        for (String s : myList)
        {
            wordList += " " + s +", ";
        }
    }

    public String getMyList()
    {
        return wordList;
    }

    public int[] getMyBeg() {
        return myBeg;
    }
}
