/*
 * Copyright 2020 MovingBlocks
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
package org.terasology.persistence.typeHandling.extensionTypes;

import org.terasology.entitySystem.Component;
import org.terasology.persistence.typeHandling.StringRepresentationTypeHandler;
import org.terasology.persistence.typeHandling.TypeHandlerContext;

public class ComponentClassTypeHandler extends StringRepresentationTypeHandler<Class<? extends Component>> {

    TypeHandlerContext context;

    public ComponentClassTypeHandler(final TypeHandlerContext context) {
        this.context = context;
    }

    @Override
    public String getAsString(Class<? extends Component> item) {
        return context.getSandbox().getSubTypeIdentifier(item, Component.class);
    }

    @Override
    public Class<? extends Component> getFromString(String representation) {
        return context.getSandbox().findSubTypeOf(representation, Component.class).orElse(null);
    }
}
