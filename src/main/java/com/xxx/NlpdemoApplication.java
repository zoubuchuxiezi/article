package com.xxx;


import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.corpus.dependency.CoNll.CoNLLSentence;
import com.hankcs.hanlp.corpus.dependency.CoNll.CoNLLWord;

public class NlpdemoApplication {

	static Map<String,String> rule_map = new HashMap<String,String>();
	public static void main(String[] args) {
		System.out.println("原始句子:闰土坐在台上");
		CoNLLSentence sentence = HanLP.parseDependency("闰土坐在台上");
        //根据句式内容生成key
		String key = getKey(sentence.getWordArray());
        //自己分析出规则，把规则放如规则库
		putRule(key,"3,1,着,0");
		//根据规则进行句子转化
        String out = changeSentence(sentence.getWordArray(),"3,1,着,0");
        System.out.println(out);
    }
	public static String getKey(CoNLLWord[] cw){
		String out = new String();
		for(int i=0 ;i<cw.length;i++){
          CoNLLWord word = cw[i];
          //System.out.printf("%s --(%s)--> %s\n", word.LEMMA, word.DEPREL, word.HEAD.LEMMA);
          out = out+word.DEPREL;
          if(word.DEPREL.equals("动补结构")){
        	  if(word.LEMMA.equals("在")){
        		  out = out+word.LEMMA;
        	  }
          }
        }
		return out;
	}
	
	public static void putRule(String key,String rule){
		rule_map.put(key, rule);
	}
	
	public static String changeSentence(CoNLLWord[] cw,String rule){
		String out = new String();
		String [] ru =  rule.split(",");
		for(int index=0; index<ru.length;index++){
			//System.out.println(ru[index]);
			try {
				int i=Integer.parseInt(ru[index]);
				out = out + cw[i].LEMMA;
			} 
			catch(NumberFormatException e){
				out = out + ru[index];
			}
		}
		return out;
	}
	
}
