/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package com.microsoft.azure.management.monitor;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The repeating times at which this profile begins. This element is not used
 * if the FixedDate element is used.
 */
public class Recurrence {
    /**
     * the recurrence frequency. How often the schedule profile should take
     * effect. This value must be Week, meaning each week will have the same
     * set of profiles. Possible values include: 'None', 'Second', 'Minute',
     * 'Hour', 'Day', 'Week', 'Month', 'Year'.
     */
    @JsonProperty(value = "frequency", required = true)
    private RecurrenceFrequency frequency;

    /**
     * the scheduling constraints for when the profile begins.
     */
    @JsonProperty(value = "schedule", required = true)
    private RecurrentSchedule schedule;

    /**
     * Get the frequency value.
     *
     * @return the frequency value
     */
    public RecurrenceFrequency frequency() {
        return this.frequency;
    }

    /**
     * Set the frequency value.
     *
     * @param frequency the frequency value to set
     * @return the Recurrence object itself.
     */
    public Recurrence withFrequency(RecurrenceFrequency frequency) {
        this.frequency = frequency;
        return this;
    }

    /**
     * Get the schedule value.
     *
     * @return the schedule value
     */
    public RecurrentSchedule schedule() {
        return this.schedule;
    }

    /**
     * Set the schedule value.
     *
     * @param schedule the schedule value to set
     * @return the Recurrence object itself.
     */
    public Recurrence withSchedule(RecurrentSchedule schedule) {
        this.schedule = schedule;
        return this;
    }

}
