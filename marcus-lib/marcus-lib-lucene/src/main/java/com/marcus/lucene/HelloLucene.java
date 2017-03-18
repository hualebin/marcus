package com.marcus.lucene;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.RAMDirectory;

public class HelloLucene {
	
	public static void main(String[] args) {
		Analyzer analyzer = new StandardAnalyzer(); //创建标准分词器
		
		Directory directory = new RAMDirectory(); //将索引保存到内存中
		/*Path path = Paths.get("/tmp/testindex");
		Directory directory = FSDirectory.open(path);*/  //将索引保存到磁盘上
		
		IndexWriterConfig config = new IndexWriterConfig(analyzer);
		
		IndexWriter iwriter = null;
		
		try {
			iwriter = new IndexWriter(directory, config);
			Document doc = new Document();
			String text = "This is the text to be indexed.";
			doc.add(new Field("fieldName", text, TextField.TYPE_STORED));
			
			iwriter.addDocument(doc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (iwriter != null) {
				try {
					iwriter.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		//开始检索索引
		
		DirectoryReader ireader = null;
		try {
			ireader = DirectoryReader.open(directory);
			IndexSearcher iSearcher = new IndexSearcher(ireader);
			//搜索"text"
			QueryParser parser = new QueryParser("fieldname", analyzer);
			Query query = parser.parse("text");
			ScoreDoc[] hits = iSearcher.search(query, 1000).scoreDocs;
			System.out.println(hits.length == 1);
		    // Iterate through the results:
		    for (int i = 0; i < hits.length; i++) {
		      Document hitDoc = iSearcher.doc(hits[i].doc);
		      System.out.println(hitDoc.get("fieldname")); //"This is the text to be indexed."
		    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (ireader != null) {
				try {
					ireader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (directory != null) {
				try {
					directory.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public void index() {
		
		Directory directory = new RAMDirectory();
		
		IndexWriterConfig iwc = new IndexWriterConfig(new StandardAnalyzer());
		
		IndexWriter iw = null;
		
		try {
			iw = new IndexWriter(directory, iwc);
			
			Document document= new Document();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (iw != null) {
				try {
					iw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}
	
	public void searcher() {
		try {
			Directory directory = new RAMDirectory();
			
			IndexReader reader = DirectoryReader.open(directory);
			
			IndexSearcher searcher = new IndexSearcher(reader);
			
			QueryParser parser = new QueryParser("fieldname", new StandardAnalyzer());
			
			Query query = parser.parse("text");
			
			TopDocs tds = searcher.search(query, 10);
			
			ScoreDoc[] sds = tds.scoreDocs;
			
			for (ScoreDoc sd : sds) {
				Document doc = searcher.doc(sd.doc);
				
				System.out.println(doc.get("fieldname"));
			}
			
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
