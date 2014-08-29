/*
 * Copyright 2014-2015 Avanza Bank AB
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
package se.avanzabank.service.suite.context;

import java.lang.annotation.Annotation;
import java.util.List;


/**
 * This is a 'client side' component used to 
 * create factory beans for a given api. <p>
 * 
 * 
 * @author Elias Lindholm (elilin)
 *
 */
public interface AstrixApiProviderPlugin {
	
	List<AstrixFactoryBean<?>> createFactoryBeans(Class<?> apiDescriptorHolder);
	
	@Deprecated // TODO: remove, replaced by consumes
	Class<? extends Annotation> getProviderAnnotationType();
	
	boolean consumes(Class<?> descriptorHolder);
	
}