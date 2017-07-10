import org.apache.spark.{SparkConf, SparkContext}
import java.io._
import scala.io.Source


/**
  * Created by nikky on 7/9/2017.
  */
object a {

  def main(args: Array[String]): Unit = {
    val z = new Array[String](100)


    val sparkConf = new SparkConf().setAppName("SparkWordCount").setMaster("local[*]")

    val sc = new SparkContext(sparkConf)

    //Reading the Text File
    val documents = sc.textFile("data/harry").toLocalIterator.mkString
    System.out.println("Enter the question")
    val ans1 = scala.io.StdIn.readLine()
    val pw = new PrintWriter(new File("ques.txt" ))
    pw.write(ans1)
    pw.close
      //Getting OpenIE Form of the word using lda.CoreNLP
     val token1="PERSON"
      val t = lemmatize.returnLemma(ans1,token1)
    System.out.println("ttttt")
    System.out.println(t)

    val a = getNGrams(documents,2)
    //a.foreach(f=>println(f.mkString(" ")))
    val filename = "ngram"
    for (line <- Source.fromFile(filename).getLines) {

      if(line.contains(t))
        {
          //System.out.println("line:::"+line)

          val z = line.split(" ", 2);

          val z1 = z(0)
          //System.out.println("z1:::"+z1)
          val t = lemmatize.returnLemma1(z1,"PERSON")
          //System.out.println("t:::"+t)

          val z2 = z(1)
          val t1 = lemmatize.returnLemma1(z2,"PERSON")
          //System.out.println("t1:::"+t1)

          if(t.contentEquals("PERSON"))
            {
            if (t1.contentEquals("PERSON"))
            {
              System.out.println("final----------------------------------- output")
              System.out.println(z1+" "+z2)
            }
            }
        }
    }}









  def getNGrams(sentence: String, n:Int): Array[Array[String]] = {
    val words = sentence
    val ngrams = words.split(' ').sliding(n)
    ngrams.toArray
  }

}
