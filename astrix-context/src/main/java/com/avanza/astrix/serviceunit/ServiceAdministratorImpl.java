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
package com.avanza.astrix.serviceunit;

import com.avanza.astrix.modules.AstrixInject;
import com.avanza.astrix.provider.core.AstrixServiceExport;

@AstrixServiceExport(ServiceAdministrator.class)
public class ServiceAdministratorImpl implements ServiceAdministrator {

	private ServiceRegistryExporter serviceRegistryExporter;
	
	@AstrixInject
	public void setServiceRegistryExporter(ServiceRegistryExporter serviceRegistryExporter) {
		this.serviceRegistryExporter = serviceRegistryExporter;
	}

	@Override
	public void setPublishServices(boolean published) {
		this.serviceRegistryExporter.setPublished(published);
	}

}
