/*
 * Copyright 2014 Avanza Bank AB
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.avanza.astrix.remoting.client;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/**
 * 
 * @author Elias Lindholm (elilin)
 *
 */
public class AstrixServiceInvocationRequest implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private final Map<String, String> headers = new HashMap<>();
	private Object[] arguments;
	
	public void setArguments(Object[] requestBody) {
		this.arguments = requestBody;
	}
	
	public Object[] getArguments() {
		return arguments;
	}

	public void setHeader(String name, String value) {
		this.headers.put(name, value);
	}
	
	public String getHeader(String name) {
		return this.headers.get(name);
	}
	
	@Override
	public String toString() {
		return "Invocation Request. headers=" + this.headers.toString() + ", arguments=" + Arrays.toString(arguments);
	}

	public Map<String, String> getHeaders() {
		return this.headers;
	}

	public void setAllHeaders(Map<String, String> headers) {
		this.headers.putAll(headers);
	}

	
}
