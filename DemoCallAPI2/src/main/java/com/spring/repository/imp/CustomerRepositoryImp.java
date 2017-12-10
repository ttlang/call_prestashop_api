package com.spring.repository.imp;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.stereotype.Repository;

import com.spring.repository.CustomerRepository;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

@Repository
public class CustomerRepositoryImp implements CustomerRepository {

	@Override
	public String getAllCustomer(int customerID) {
		Client client = Client.create();
		client.addFilter(
				new HTTPBasicAuthFilter("1MCHM7FQFMAQHSDAQS5IDKR3AZLLSBVH", "1MCHM7FQFMAQHSDAQS5IDKR3AZLLSBVH"));
		WebResource webResource = client.resource("http://localhost:81/prestashop/api/customers/" + customerID);
		ClientResponse response = webResource.accept("application/xml").get(ClientResponse.class);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}

		String output = response.getEntity(String.class);

		String json = null;
		try {
			json = XML.toJSONObject(output).toString();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return json;
	}

	@Override
	public String convertJsonToXML(String json) {
		String xml = null;
		try {
			JSONObject jsonObject = new JSONObject(json);
			xml = XML.toString(jsonObject);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return xml;
	}

}
