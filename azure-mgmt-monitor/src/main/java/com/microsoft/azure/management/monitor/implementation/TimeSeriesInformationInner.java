/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package com.microsoft.azure.management.monitor.implementation;

import java.util.List;
import org.joda.time.DateTime;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The time series info needed for calculating the baseline.
 */
public class TimeSeriesInformationInner {
    /**
     * the list of sensitivities for calculating the baseline.
     */
    @JsonProperty(value = "sensitivities", required = true)
    private List<String> sensitivities;

    /**
     * The metric values to calculate the baseline.
     */
    @JsonProperty(value = "values", required = true)
    private List<Double> values;

    /**
     * the array of timestamps of the baselines.
     */
    @JsonProperty(value = "timestamps")
    private List<DateTime> timestamps;

    /**
     * Get the sensitivities value.
     *
     * @return the sensitivities value
     */
    public List<String> sensitivities() {
        return this.sensitivities;
    }

    /**
     * Set the sensitivities value.
     *
     * @param sensitivities the sensitivities value to set
     * @return the TimeSeriesInformationInner object itself.
     */
    public TimeSeriesInformationInner withSensitivities(List<String> sensitivities) {
        this.sensitivities = sensitivities;
        return this;
    }

    /**
     * Get the values value.
     *
     * @return the values value
     */
    public List<Double> values() {
        return this.values;
    }

    /**
     * Set the values value.
     *
     * @param values the values value to set
     * @return the TimeSeriesInformationInner object itself.
     */
    public TimeSeriesInformationInner withValues(List<Double> values) {
        this.values = values;
        return this;
    }

    /**
     * Get the timestamps value.
     *
     * @return the timestamps value
     */
    public List<DateTime> timestamps() {
        return this.timestamps;
    }

    /**
     * Set the timestamps value.
     *
     * @param timestamps the timestamps value to set
     * @return the TimeSeriesInformationInner object itself.
     */
    public TimeSeriesInformationInner withTimestamps(List<DateTime> timestamps) {
        this.timestamps = timestamps;
        return this;
    }

}
