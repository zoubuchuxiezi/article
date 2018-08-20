package com.article.util;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.corpus.dependency.CoNll.CoNLLSentence;
import com.hankcs.hanlp.corpus.dependency.CoNll.CoNLLWord;

public class SentenceHandler {

    public static String getKey(String sentence){
        CoNLLSentence se = HanLP.parseDependency(sentence);
        return getZaiKey(se.getWordArray());
    }
    public static String getZaiKey(CoNLLWord[] cw){
        StringBuffer str = new StringBuffer();
        for(int i=0 ;i<cw.length;i++){
            CoNLLWord word = cw[i];
            //System.out.printf("%s --(%s)--> %s\n", word.LEMMA, word.DEPREL, word.HEAD.LEMMA);
            str.append(word.DEPREL);
            if(word.DEPREL.equals("动补结构")){
                if(word.LEMMA.equals("在")){
                    str.append(word.LEMMA);
                }
            }
        }
        return str.toString();
    }

    public static String changeSentence(String sentence,String rule){
        CoNLLSentence se = HanLP.parseDependency(sentence);
        StringBuffer out = new StringBuffer();
        String [] ru =  rule.split(",");
        for(int index=0; index<ru.length;index++){
            //System.out.println(ru[index]);
            try {
                int i=Integer.parseInt(ru[index]);
                out.append(se.getWordArray()[i].LEMMA);
            }
            catch(NumberFormatException e){
                out.append(ru[index]);
            }
        }
        return out.toString();
    }
}
