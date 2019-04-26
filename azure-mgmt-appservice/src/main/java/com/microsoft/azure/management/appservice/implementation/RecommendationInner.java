/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.appservice.implementation;

import org.joda.time.DateTime;
import java.util.UUID;
import com.microsoft.azure.management.appservice.ResourceScopeType;
import com.microsoft.azure.management.appservice.NotificationLevel;
import com.microsoft.azure.management.appservice.Channels;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;
import com.microsoft.azure.management.appservice.ProxyOnlyResource;

/**
 * Represents a recommendation result generated by the recommendation engine.
 */
@JsonFlatten
public class RecommendationInner extends ProxyOnlyResource {
    /**
     * Timestamp when this instance was created.
     */
    @JsonProperty(value = "properties.creationTime")
    private DateTime creationTime;

    /**
     * A GUID value that each recommendation object is associated with.
     */
    @JsonProperty(value = "properties.recommendationId")
    private UUID recommendationId;

    /**
     * Full ARM resource ID string that this recommendation object is
     * associated with.
     */
    @JsonProperty(value = "properties.resourceId")
    private String resourceId;

    /**
     * Name of a resource type this recommendation applies, e.g. Subscription,
     * ServerFarm, Site. Possible values include: 'ServerFarm', 'Subscription',
     * 'WebSite'.
     */
    @JsonProperty(value = "properties.resourceScope")
    private ResourceScopeType resourceScope;

    /**
     * Unique name of the rule.
     */
    @JsonProperty(value = "properties.ruleName")
    private String ruleName;

    /**
     * UI friendly name of the rule (may not be unique).
     */
    @JsonProperty(value = "properties.displayName")
    private String displayName;

    /**
     * Recommendation text.
     */
    @JsonProperty(value = "properties.message")
    private String message;

    /**
     * Level indicating how critical this recommendation can impact. Possible
     * values include: 'Critical', 'Warning', 'Information',
     * 'NonUrgentSuggestion'.
     */
    @JsonProperty(value = "properties.level")
    private NotificationLevel level;

    /**
     * List of channels that this recommendation can apply. Possible values
     * include: 'Notification', 'Api', 'Email', 'Webhook', 'All'.
     */
    @JsonProperty(value = "properties.channels")
    private Channels channels;

    /**
     * The list of category tags that this recommendation belongs to.
     */
    @JsonProperty(value = "properties.categoryTags", access = JsonProperty.Access.WRITE_ONLY)
    private List<String> categoryTags;

    /**
     * Name of action recommended by this object.
     */
    @JsonProperty(value = "properties.actionName")
    private String actionName;

    /**
     * True if this recommendation is still valid (i.e. "actionable"). False if
     * it is invalid.
     */
    @JsonProperty(value = "properties.enabled")
    private Integer enabled;

    /**
     * The list of states of this recommendation. If it's null then it should
     * be considered "Active".
     */
    @JsonProperty(value = "properties.states")
    private List<String> states;

    /**
     * The beginning time in UTC of a range that the recommendation refers to.
     */
    @JsonProperty(value = "properties.startTime")
    private DateTime startTime;

    /**
     * The end time in UTC of a range that the recommendation refers to.
     */
    @JsonProperty(value = "properties.endTime")
    private DateTime endTime;

    /**
     * When to notify this recommendation next in UTC. Null means that this
     * will never be notified anymore.
     */
    @JsonProperty(value = "properties.nextNotificationTime")
    private DateTime nextNotificationTime;

    /**
     * Date and time in UTC when this notification expires.
     */
    @JsonProperty(value = "properties.notificationExpirationTime")
    private DateTime notificationExpirationTime;

    /**
     * Last timestamp in UTC this instance was actually notified. Null means
     * that this recommendation hasn't been notified yet.
     */
    @JsonProperty(value = "properties.notifiedTime")
    private DateTime notifiedTime;

    /**
     * A metric value measured by the rule.
     */
    @JsonProperty(value = "properties.score")
    private Double score;

    /**
     * True if this is associated with a dynamically added rule.
     */
    @JsonProperty(value = "properties.isDynamic")
    private Boolean isDynamic;

    /**
     * Extension name of the portal if exists.
     */
    @JsonProperty(value = "properties.extensionName")
    private String extensionName;

    /**
     * Deep link to a blade on the portal.
     */
    @JsonProperty(value = "properties.bladeName")
    private String bladeName;

    /**
     * Forward link to an external document associated with the rule.
     */
    @JsonProperty(value = "properties.forwardLink")
    private String forwardLink;

    /**
     * Get timestamp when this instance was created.
     *
     * @return the creationTime value
     */
    public DateTime creationTime() {
        return this.creationTime;
    }

    /**
     * Set timestamp when this instance was created.
     *
     * @param creationTime the creationTime value to set
     * @return the RecommendationInner object itself.
     */
    public RecommendationInner withCreationTime(DateTime creationTime) {
        this.creationTime = creationTime;
        return this;
    }

    /**
     * Get a GUID value that each recommendation object is associated with.
     *
     * @return the recommendationId value
     */
    public UUID recommendationId() {
        return this.recommendationId;
    }

    /**
     * Set a GUID value that each recommendation object is associated with.
     *
     * @param recommendationId the recommendationId value to set
     * @return the RecommendationInner object itself.
     */
    public RecommendationInner withRecommendationId(UUID recommendationId) {
        this.recommendationId = recommendationId;
        return this;
    }

    /**
     * Get full ARM resource ID string that this recommendation object is associated with.
     *
     * @return the resourceId value
     */
    public String resourceId() {
        return this.resourceId;
    }

    /**
     * Set full ARM resource ID string that this recommendation object is associated with.
     *
     * @param resourceId the resourceId value to set
     * @return the RecommendationInner object itself.
     */
    public RecommendationInner withResourceId(String resourceId) {
        this.resourceId = resourceId;
        return this;
    }

    /**
     * Get name of a resource type this recommendation applies, e.g. Subscription, ServerFarm, Site. Possible values include: 'ServerFarm', 'Subscription', 'WebSite'.
     *
     * @return the resourceScope value
     */
    public ResourceScopeType resourceScope() {
        return this.resourceScope;
    }

    /**
     * Set name of a resource type this recommendation applies, e.g. Subscription, ServerFarm, Site. Possible values include: 'ServerFarm', 'Subscription', 'WebSite'.
     *
     * @param resourceScope the resourceScope value to set
     * @return the RecommendationInner object itself.
     */
    public RecommendationInner withResourceScope(ResourceScopeType resourceScope) {
        this.resourceScope = resourceScope;
        return this;
    }

    /**
     * Get unique name of the rule.
     *
     * @return the ruleName value
     */
    public String ruleName() {
        return this.ruleName;
    }

    /**
     * Set unique name of the rule.
     *
     * @param ruleName the ruleName value to set
     * @return the RecommendationInner object itself.
     */
    public RecommendationInner withRuleName(String ruleName) {
        this.ruleName = ruleName;
        return this;
    }

    /**
     * Get uI friendly name of the rule (may not be unique).
     *
     * @return the displayName value
     */
    public String displayName() {
        return this.displayName;
    }

    /**
     * Set uI friendly name of the rule (may not be unique).
     *
     * @param displayName the displayName value to set
     * @return the RecommendationInner object itself.
     */
    public RecommendationInner withDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * Get recommendation text.
     *
     * @return the message value
     */
    public String message() {
        return this.message;
    }

    /**
     * Set recommendation text.
     *
     * @param message the message value to set
     * @return the RecommendationInner object itself.
     */
    public RecommendationInner withMessage(String message) {
        this.message = message;
        return this;
    }

    /**
     * Get level indicating how critical this recommendation can impact. Possible values include: 'Critical', 'Warning', 'Information', 'NonUrgentSuggestion'.
     *
     * @return the level value
     */
    public NotificationLevel level() {
        return this.level;
    }

    /**
     * Set level indicating how critical this recommendation can impact. Possible values include: 'Critical', 'Warning', 'Information', 'NonUrgentSuggestion'.
     *
     * @param level the level value to set
     * @return the RecommendationInner object itself.
     */
    public RecommendationInner withLevel(NotificationLevel level) {
        this.level = level;
        return this;
    }

    /**
     * Get list of channels that this recommendation can apply. Possible values include: 'Notification', 'Api', 'Email', 'Webhook', 'All'.
     *
     * @return the channels value
     */
    public Channels channels() {
        return this.channels;
    }

    /**
     * Set list of channels that this recommendation can apply. Possible values include: 'Notification', 'Api', 'Email', 'Webhook', 'All'.
     *
     * @param channels the channels value to set
     * @return the RecommendationInner object itself.
     */
    public RecommendationInner withChannels(Channels channels) {
        this.channels = channels;
        return this;
    }

    /**
     * Get the list of category tags that this recommendation belongs to.
     *
     * @return the categoryTags value
     */
    public List<String> categoryTags() {
        return this.categoryTags;
    }

    /**
     * Get name of action recommended by this object.
     *
     * @return the actionName value
     */
    public String actionName() {
        return this.actionName;
    }

    /**
     * Set name of action recommended by this object.
     *
     * @param actionName the actionName value to set
     * @return the RecommendationInner object itself.
     */
    public RecommendationInner withActionName(String actionName) {
        this.actionName = actionName;
        return this;
    }

    /**
     * Get true if this recommendation is still valid (i.e. "actionable"). False if it is invalid.
     *
     * @return the enabled value
     */
    public Integer enabled() {
        return this.enabled;
    }

    /**
     * Set true if this recommendation is still valid (i.e. "actionable"). False if it is invalid.
     *
     * @param enabled the enabled value to set
     * @return the RecommendationInner object itself.
     */
    public RecommendationInner withEnabled(Integer enabled) {
        this.enabled = enabled;
        return this;
    }

    /**
     * Get the list of states of this recommendation. If it's null then it should be considered "Active".
     *
     * @return the states value
     */
    public List<String> states() {
        return this.states;
    }

    /**
     * Set the list of states of this recommendation. If it's null then it should be considered "Active".
     *
     * @param states the states value to set
     * @return the RecommendationInner object itself.
     */
    public RecommendationInner withStates(List<String> states) {
        this.states = states;
        return this;
    }

    /**
     * Get the beginning time in UTC of a range that the recommendation refers to.
     *
     * @return the startTime value
     */
    public DateTime startTime() {
        return this.startTime;
    }

    /**
     * Set the beginning time in UTC of a range that the recommendation refers to.
     *
     * @param startTime the startTime value to set
     * @return the RecommendationInner object itself.
     */
    public RecommendationInner withStartTime(DateTime startTime) {
        this.startTime = startTime;
        return this;
    }

    /**
     * Get the end time in UTC of a range that the recommendation refers to.
     *
     * @return the endTime value
     */
    public DateTime endTime() {
        return this.endTime;
    }

    /**
     * Set the end time in UTC of a range that the recommendation refers to.
     *
     * @param endTime the endTime value to set
     * @return the RecommendationInner object itself.
     */
    public RecommendationInner withEndTime(DateTime endTime) {
        this.endTime = endTime;
        return this;
    }

    /**
     * Get when to notify this recommendation next in UTC. Null means that this will never be notified anymore.
     *
     * @return the nextNotificationTime value
     */
    public DateTime nextNotificationTime() {
        return this.nextNotificationTime;
    }

    /**
     * Set when to notify this recommendation next in UTC. Null means that this will never be notified anymore.
     *
     * @param nextNotificationTime the nextNotificationTime value to set
     * @return the RecommendationInner object itself.
     */
    public RecommendationInner withNextNotificationTime(DateTime nextNotificationTime) {
        this.nextNotificationTime = nextNotificationTime;
        return this;
    }

    /**
     * Get date and time in UTC when this notification expires.
     *
     * @return the notificationExpirationTime value
     */
    public DateTime notificationExpirationTime() {
        return this.notificationExpirationTime;
    }

    /**
     * Set date and time in UTC when this notification expires.
     *
     * @param notificationExpirationTime the notificationExpirationTime value to set
     * @return the RecommendationInner object itself.
     */
    public RecommendationInner withNotificationExpirationTime(DateTime notificationExpirationTime) {
        this.notificationExpirationTime = notificationExpirationTime;
        return this;
    }

    /**
     * Get last timestamp in UTC this instance was actually notified. Null means that this recommendation hasn't been notified yet.
     *
     * @return the notifiedTime value
     */
    public DateTime notifiedTime() {
        return this.notifiedTime;
    }

    /**
     * Set last timestamp in UTC this instance was actually notified. Null means that this recommendation hasn't been notified yet.
     *
     * @param notifiedTime the notifiedTime value to set
     * @return the RecommendationInner object itself.
     */
    public RecommendationInner withNotifiedTime(DateTime notifiedTime) {
        this.notifiedTime = notifiedTime;
        return this;
    }

    /**
     * Get a metric value measured by the rule.
     *
     * @return the score value
     */
    public Double score() {
        return this.score;
    }

    /**
     * Set a metric value measured by the rule.
     *
     * @param score the score value to set
     * @return the RecommendationInner object itself.
     */
    public RecommendationInner withScore(Double score) {
        this.score = score;
        return this;
    }

    /**
     * Get true if this is associated with a dynamically added rule.
     *
     * @return the isDynamic value
     */
    public Boolean isDynamic() {
        return this.isDynamic;
    }

    /**
     * Set true if this is associated with a dynamically added rule.
     *
     * @param isDynamic the isDynamic value to set
     * @return the RecommendationInner object itself.
     */
    public RecommendationInner withIsDynamic(Boolean isDynamic) {
        this.isDynamic = isDynamic;
        return this;
    }

    /**
     * Get extension name of the portal if exists.
     *
     * @return the extensionName value
     */
    public String extensionName() {
        return this.extensionName;
    }

    /**
     * Set extension name of the portal if exists.
     *
     * @param extensionName the extensionName value to set
     * @return the RecommendationInner object itself.
     */
    public RecommendationInner withExtensionName(String extensionName) {
        this.extensionName = extensionName;
        return this;
    }

    /**
     * Get deep link to a blade on the portal.
     *
     * @return the bladeName value
     */
    public String bladeName() {
        return this.bladeName;
    }

    /**
     * Set deep link to a blade on the portal.
     *
     * @param bladeName the bladeName value to set
     * @return the RecommendationInner object itself.
     */
    public RecommendationInner withBladeName(String bladeName) {
        this.bladeName = bladeName;
        return this;
    }

    /**
     * Get forward link to an external document associated with the rule.
     *
     * @return the forwardLink value
     */
    public String forwardLink() {
        return this.forwardLink;
    }

    /**
     * Set forward link to an external document associated with the rule.
     *
     * @param forwardLink the forwardLink value to set
     * @return the RecommendationInner object itself.
     */
    public RecommendationInner withForwardLink(String forwardLink) {
        this.forwardLink = forwardLink;
        return this;
    }

}
