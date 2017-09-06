package dk.mikkelrj.confluence.rest.client.impl;

import java.util.concurrent.ExecutorService;

import de.itboehmer.confluence.rest.client.ContentClient;
import de.itboehmer.confluence.rest.client.SearchClient;
import de.itboehmer.confluence.rest.client.SpaceClient;
import de.itboehmer.confluence.rest.client.UserClient;
import dk.mikkelrj.confluence.rest.client.ClientFactory;
import dk.mikkelrj.confluence.rest.core.RequestService;
import dk.mikkelrj.confluence.rest.core.impl.AtlassianAPIConfig;

public final class ClientFactoryImpl implements ClientFactory {

	private final ExecutorService executorService;
	private final RequestService requestService;
	private final AtlassianAPIConfig apiConfig;
	
	public ClientFactoryImpl(ExecutorService executorService, RequestService requestService, AtlassianAPIConfig apiConfig) {
		this.executorService = executorService;
		this.requestService = requestService;
		this.apiConfig = apiConfig;
	}
	
	public UserClient getUserClient() {
		return new UserClientImpl(executorService, requestService, apiConfig);
	}

	@Override
	public SpaceClient getSpaceClient() {
		return new SpaceClientImpl(executorService, requestService, apiConfig);
	}

	@Override
	public ContentClient getContentClient() {
		return new ContentClientImpl(executorService, requestService, apiConfig);
	}

	@Override
	public SearchClient getSearchClient() {
		return new SearchClientImpl(executorService, requestService, apiConfig);
	}
}
