package com.marklogic.client.spring.batch.writer;

import java.util.List;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.document.XMLDocumentManager;
import com.marklogic.client.helper.DatabaseClientProvider;
import com.marklogic.client.io.DOMHandle;

import org.w3c.dom.Document;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

public class DocumentItemWriter implements ItemWriter<Document> {

	@Autowired
	private DatabaseClientProvider databaseClientProvider;
	
	@Override
	public void write(List<? extends Document> items) throws Exception {
		DatabaseClient client = databaseClientProvider.getDatabaseClient();
		XMLDocumentManager docMgr = client.newXMLDocumentManager();
		for (int i = 0; i < items.size(); i++) {
			Document doc = items.get(i);
			DOMHandle handle = new DOMHandle(doc);
			docMgr.write(doc.getDocumentURI(), handle);
		}		
	}

}
