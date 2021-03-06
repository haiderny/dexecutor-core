/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.dexecutor.core.graph;

import org.junit.Test;

/**
 * 
 * @author Nadeem Mohammad
 *
 */
public class CyclicValidatorTest {

	@Test(expected= IllegalArgumentException.class)
	public void vlidateExceptionThrown() {
		Dag<Integer, Integer> graph = new DefaultDag<Integer, Integer>();
		graph.addDependency(1, 2);
		graph.addDependency(2, 3);
		graph.addDependency(1, 4);
		graph.addDependency(2, 1);
		
		Validator<Integer, Integer> validator = new CyclicValidator<Integer, Integer>();
		validator.validate(graph);
	}

	@Test
	public void vlidateNoExceptionThrown() {
		Dag<Integer, Integer> graph = new DefaultDag<Integer, Integer>();
		graph.addDependency(1, 2);
		graph.addDependency(2, 3);
		graph.addDependency(1, 4);
		
		Validator<Integer, Integer> validator = new CyclicValidator<Integer, Integer>();
		validator.validate(graph);
	}

}
