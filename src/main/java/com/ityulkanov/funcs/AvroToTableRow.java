package com.ityulkanov.funcs;

import com.google.api.services.bigquery.model.TableRow;
import com.ityulkanov.model.Sale;
import org.apache.beam.sdk.transforms.DoFn;

public class AvroToTableRow extends DoFn<Sale, TableRow> {

    @ProcessElement
    public void processElement(ProcessContext c) {
        Sale sale = c.element();
        TableRow tableRow = new TableRow()
                .set("product_name", sale != null ? sale.getProductName() : null)
                .set("store_id", sale != null ? sale.getStoreID() : null)
                .set("product_id", sale != null ? sale.getProductID() : null)
                .set("price", sale != null ? sale.getPrice() : null)
                .set("discount", sale != null ? sale.getDiscount() : null)
                .set("updated_price", sale != null ? sale.getUpdatedPrice() : null)
                .set("transaction_id", sale != null ? sale.getTransactionID() : null)
                .set("sales_date", sale != null ? sale.getSalesDate() : null);
        c.output(tableRow);
    }
}