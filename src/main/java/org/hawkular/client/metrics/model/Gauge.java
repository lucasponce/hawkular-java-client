/*
 * Copyright 2015 Red Hat, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.hawkular.client.metrics.model;

import static java.util.Collections.unmodifiableList;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A container for gauge data points to be persisted. Note that the tenant id is not included because it is obtained
 * from the tenant header in the HTTP request.
 *
 * @author jsanda
 */
public class Gauge {

    @JsonProperty
    private String id;

    @JsonProperty
    private List<GaugeDataPoint> data;

    public String getId() {
        return id;
    }

    public List<GaugeDataPoint> getData() {
        return unmodifiableList(data);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gauge gauge = (Gauge) o;
        return Objects.equals(id, gauge.id) &&
                Objects.equals(data, gauge.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, data);
    }

    @Override
    public String toString() {
        return com.google.common.base.Objects.toStringHelper(this)
                .add("id", id)
                .add("data", data)
                .toString();
    }
}
