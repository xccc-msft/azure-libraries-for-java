/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.management.storage.implementation;

import com.microsoft.azure.management.apigeneration.LangDefinition;
import com.microsoft.azure.management.resources.fluentcore.model.implementation.WrapperImpl;
import com.microsoft.azure.management.storage.BlobContainer;
import com.microsoft.azure.management.storage.BlobContainers;
import com.microsoft.azure.management.storage.ImmutabilityPolicy;
import com.microsoft.azure.management.storage.LegalHold;
import com.microsoft.azure.management.storage.ListContainerItems;
import rx.Completable;
import rx.Observable;
import rx.functions.Func1;

import java.util.List;

@LangDefinition
class BlobContainersImpl extends WrapperImpl<BlobContainersInner> implements BlobContainers {
    private final StorageManager manager;

    BlobContainersImpl(StorageManager manager) {
        super(manager.inner().blobContainers());
        this.manager = manager;
    }

    public StorageManager manager() {
        return this.manager;
    }

    @Override
    public BlobContainerImpl defineContainer(String name) {
        return wrapContainerModel(name);
    }

    @Override
    public ImmutabilityPolicyImpl defineImmutabilityPolicy(String name) {
        return wrapImmutabilityPolicyModel(name);
    }

    private BlobContainerImpl wrapContainerModel(String name) {
        return new BlobContainerImpl(name, this.manager());
    }

    private ImmutabilityPolicyImpl wrapImmutabilityPolicyModel(String name) {
        return new ImmutabilityPolicyImpl(name, this.manager());
    }

    private BlobContainerImpl wrapBlobContainerModel(BlobContainerInner inner) {
        return  new BlobContainerImpl(inner, manager());
    }

    private ImmutabilityPolicyImpl wrapImmutabilityPolicyModel(ImmutabilityPolicyInner inner) {
        return  new ImmutabilityPolicyImpl(inner, manager());
    }

    private Observable<ImmutabilityPolicyInner> getImmutabilityPolicyInnerUsingBlobContainersInnerAsync(String id) {
        String resourceGroupName = IdParsingUtils.getValueFromIdByName(id, "resourceGroups");
        String accountName = IdParsingUtils.getValueFromIdByName(id, "storageAccounts");
        String containerName = IdParsingUtils.getValueFromIdByName(id, "containers");
        BlobContainersInner client = this.inner();
        return client.getImmutabilityPolicyAsync(resourceGroupName, accountName, containerName);
    }

    @Override
    public Observable<ListContainerItems> listAsync(String resourceGroupName, String accountName) {
        BlobContainersInner client = this.inner();
        return client.listAsync(resourceGroupName, accountName)
                .map(new Func1<ListContainerItemsInner, ListContainerItems>() {
                    @Override
                    public ListContainerItems call(ListContainerItemsInner inner) {
                        return new ListContainerItemsImpl(inner, manager());
                    }
                });
    }

    @Override
    public Observable<BlobContainer> getAsync(String resourceGroupName, String accountName, String containerName) {
        BlobContainersInner client = this.inner();
        return client.getAsync(resourceGroupName, accountName, containerName)
                .map(new Func1<BlobContainerInner, BlobContainer>() {
                    @Override
                    public BlobContainer call(BlobContainerInner inner) {
                        return new BlobContainerImpl(inner, manager());
                    }
                });
    }

    @Override
    public Completable deleteAsync(String resourceGroupName, String accountName, String containerName) {
        BlobContainersInner client = this.inner();
        return client.deleteAsync(resourceGroupName, accountName, containerName).toCompletable();
    }

    @Override
    public Observable<LegalHold> setLegalHoldAsync(String resourceGroupName, String accountName, String containerName, List<String> tags) {
        BlobContainersInner client = this.inner();
        return client.setLegalHoldAsync(resourceGroupName, accountName, containerName, tags)
                .map(new Func1<LegalHoldInner, LegalHold>() {
                    @Override
                    public LegalHold call(LegalHoldInner inner) {
                        return new LegalHoldImpl(inner, manager());
                    }
                });
    }

    @Override
    public Observable<LegalHold> clearLegalHoldAsync(String resourceGroupName, String accountName, String containerName, List<String> tags) {
        BlobContainersInner client = this.inner();
        return client.clearLegalHoldAsync(resourceGroupName, accountName, containerName, tags)
                .map(new Func1<LegalHoldInner, LegalHold>() {
                    @Override
                    public LegalHold call(LegalHoldInner inner) {
                        return new LegalHoldImpl(inner, manager());
                    }
                });
    }

    @Override
    public Observable<ImmutabilityPolicy> getImmutabilityPolicyAsync(String resourceGroupName, String accountName, String containerName) {
        BlobContainersInner client = this.inner();
        return client.getImmutabilityPolicyAsync(resourceGroupName, accountName, containerName)
                .map(new Func1<ImmutabilityPolicyInner, ImmutabilityPolicy>() {
                    @Override
                    public ImmutabilityPolicy call(ImmutabilityPolicyInner inner) {
                        return wrapImmutabilityPolicyModel(inner);
                    }
                });
    }

    @Override
    public Completable deleteImmutabilityPolicyAsync(String resourceGroupName, String accountName, String containerName, String ifMatch) {
        BlobContainersInner client = this.inner();
        return client.deleteImmutabilityPolicyAsync(resourceGroupName, accountName, containerName, ifMatch).toCompletable();
    }

    @Override
    public Observable<ImmutabilityPolicy> lockImmutabilityPolicyAsync(String resourceGroupName, String accountName, String containerName, String ifMatch) {
        BlobContainersInner client = this.inner();
        return client.lockImmutabilityPolicyAsync(resourceGroupName, accountName, containerName, ifMatch)
                .map(new Func1<ImmutabilityPolicyInner, ImmutabilityPolicy>() {
                    @Override
                    public ImmutabilityPolicy call(ImmutabilityPolicyInner inner) {
                        return new ImmutabilityPolicyImpl(inner, manager());
                    }
                });
    }

    @Override
    public Observable<ImmutabilityPolicy> extendImmutabilityPolicyAsync(String resourceGroupName, String accountName, String containerName, String ifMatch, int immutabilityPeriodSinceCreationInDays) {
        BlobContainersInner client = this.inner();
        return client.extendImmutabilityPolicyAsync(resourceGroupName, accountName, containerName, ifMatch, immutabilityPeriodSinceCreationInDays)
                .map(new Func1<ImmutabilityPolicyInner, ImmutabilityPolicy>() {
                    @Override
                    public ImmutabilityPolicy call(ImmutabilityPolicyInner inner) {
                        return new ImmutabilityPolicyImpl(inner, manager());
                    }
                });
    }

}