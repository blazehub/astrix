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
package com.avanza.astrix.beans.registry;

import java.util.Arrays;
import java.util.List;

import com.avanza.astrix.versioning.jackson2.AstrixJsonApiMigration;
import com.avanza.astrix.versioning.jackson2.Jackson2ObjectSerializerConfigurer;
import com.avanza.astrix.versioning.jackson2.JacksonObjectMapperBuilder;

public class ServiceRegistryObjectSerializerConfigurer implements Jackson2ObjectSerializerConfigurer {
	
	public static final int VERSION = 2;

	@Override
	public List<? extends AstrixJsonApiMigration> apiMigrations() {
		return Arrays.asList(new ServiceRegistryV1ApiMigration());
	}
	
	@Override
	public void configure(JacksonObjectMapperBuilder objectMapperBuilder) {
	}


}
