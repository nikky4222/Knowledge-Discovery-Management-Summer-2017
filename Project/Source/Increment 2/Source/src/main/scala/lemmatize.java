import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Properties;

/**
 * Created by nikky on 6/29/2017.
 */
public class lemmatize implements Serializable {
  public static String returnLemma(String sentence1, String token1)throws IOException {
    {
      //ArrayList<String> per = new ArrayList<String>();
      StringBuilder per=new StringBuilder();
      StringBuilder per1=new StringBuilder();
      StringBuilder per22=new StringBuilder();



      // creates a StanfordCoreNLP object, with POS tagging, lemmatization, NER, parsing, and coreference resolution
      Properties props = new Properties();
      props.setProperty("annotators", "tokenize, ssplit, pos, lemma, ner, parse, dcoref");
      StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
      System.out.println(sentence1);
      String lastWord = sentence1.substring(sentence1.lastIndexOf(" ")+1);
      System.out.println("lasttt"+lastWord);
      Annotation document = new Annotation(sentence1);

// run all Annotators on this text
      pipeline.annotate(document);

      // these are all the sentences in this document
// a CoreMap is essentially a Map that uses class objects as keys and has values with custom types
      List<CoreMap> sentences = document.get(CoreAnnotations.SentencesAnnotation.class);
    System.out.println("sen"+sentences);
      for (CoreMap sentence : sentences) {

        // traversing the words in the current sentence
        // a CoreLabel is a CoreMap with additional token-specific methods
        for (CoreLabel token : sentence.get(CoreAnnotations.TokensAnnotation.class)) {


          // this is the text of the token
          String word = token.get(CoreAnnotations.TextAnnotation.class);
          // this is the POS tag of the token

          String lemma = token.get(CoreAnnotations.LemmaAnnotation.class);
          // this is the Lemmatized tag of the token


          String pos = token.get(CoreAnnotations.PartOfSpeechAnnotation.class);
          //System.out.println(token + ":" + pos);

          // this is the NER label of the token
          String ne = token.get(CoreAnnotations.NamedEntityTagAnnotation.class);


          //System.out.println(token + ":" + pos);
          System.out.println(token + ":" + ne);

          if (ne.contentEquals(token1)||ne.contentEquals(lastWord)) {
            per.append(word+"");

          }



        }

      }

return  per.toString();
    }


  }

  public static String returnLemma1(String sentence1, String token1)throws IOException {
    {
      //ArrayList<String> per = new ArrayList<String>();
      StringBuilder per = new StringBuilder();
      StringBuilder per1 = new StringBuilder();


      // creates a StanfordCoreNLP object, with POS tagging, lemmatization, NER, parsing, and coreference resolution
      Properties props = new Properties();
      props.setProperty("annotators", "tokenize, ssplit, pos, lemma, ner, parse, dcoref");
      StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
      String lastWord = sentence1.substring(sentence1.lastIndexOf(" ") + 1);
      Annotation document = new Annotation(sentence1);

// run all Annotators on this text
      pipeline.annotate(document);

      // these are all the sentences in this document
// a CoreMap is essentially a Map that uses class objects as keys and has values with custom types
      List<CoreMap> sentences = document.get(CoreAnnotations.SentencesAnnotation.class);
     // System.out.println("sen" + sentences);
      for (CoreMap sentence : sentences) {

        // traversing the words in the current sentence
        // a CoreLabel is a CoreMap with additional token-specific methods
        for (CoreLabel token : sentence.get(CoreAnnotations.TokensAnnotation.class)) {


          // this is the text of the token
          String word = token.get(CoreAnnotations.TextAnnotation.class);
          // this is the POS tag of the token

          String lemma = token.get(CoreAnnotations.LemmaAnnotation.class);
          // this is the Lemmatized tag of the token


          //String pos = token.get(CoreAnnotations.PartOfSpeechAnnotation.class);
          //System.out.println(token + ":" + pos);

          // this is the NER label of the token
          String ne = token.get(CoreAnnotations.NamedEntityTagAnnotation.class);


          //System.out.println(token + ":" + pos);
          //System.out.println(token + "::::::" + ne);

          return (ne);

        }


      }

      return per1.toString();

    }


  }}

