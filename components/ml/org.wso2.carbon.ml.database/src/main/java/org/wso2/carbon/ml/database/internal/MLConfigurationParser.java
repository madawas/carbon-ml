/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.ml.database.internal;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.wso2.carbon.ml.commons.domain.config.MLConfiguration;
import org.wso2.carbon.ml.database.exceptions.MLConfigurationParserException;

/**
 * Class contains methods for parsing configurations from machine-learner.xml XML file.
 */
public class MLConfigurationParser {

    public MLConfigurationParser() {
    }

    public MLConfiguration getMLConfiguration(String mlConfigPath) throws MLConfigurationParserException {
        try {
            File file = new File(mlConfigPath);
            JAXBContext jaxbContext = JAXBContext.newInstance(MLConfiguration.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            return (MLConfiguration) jaxbUnmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            throw new MLConfigurationParserException("An error occurred while parsing: " + mlConfigPath + ": "
                    + e.getMessage(), e);
        }
    }

}
