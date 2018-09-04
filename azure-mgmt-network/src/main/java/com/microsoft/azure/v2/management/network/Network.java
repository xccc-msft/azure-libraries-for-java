/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */
package com.microsoft.azure.v2.management.network;

import java.util.List;
import java.util.Map;

import com.microsoft.azure.management.apigeneration.Fluent;
import com.microsoft.azure.management.apigeneration.Method;
import com.microsoft.azure.v2.management.network.implementation.NetworkManager;
import com.microsoft.azure.v2.management.network.implementation.VirtualNetworkInner;
import com.microsoft.azure.v2.management.network.model.UpdatableWithTags;
import com.microsoft.azure.v2.management.resources.fluentcore.arm.models.GroupableResource;
import com.microsoft.azure.v2.management.resources.fluentcore.arm.models.Resource;
import com.microsoft.azure.v2.management.resources.fluentcore.model.Appliable;
import com.microsoft.azure.v2.management.resources.fluentcore.model.Creatable;
import com.microsoft.azure.v2.management.resources.fluentcore.model.Refreshable;
import com.microsoft.azure.v2.management.resources.fluentcore.model.Updatable;
import com.microsoft.rest.v2.annotations.Beta;

/**
 * Entry point for Virtual Network management API in Azure.
 */
@Fluent()
public interface Network extends
        GroupableResource<NetworkManager, VirtualNetworkInner>,
        Refreshable<Network>,
        Updatable<Network.Update>,
        UpdatableWithTags<Network> {

    /**
     * Checks if the specified private IP address is available in this network.
     * @param ipAddress an IP address from this network's address space
     * @return true if the address is within this network's address space and is available
     */
    @Beta(since = "V1_3_0")
    boolean isPrivateIPAddressAvailable(String ipAddress);

    /**
     * Checks if the specified private IP address is within this network's address space.
     * @param ipAddress an IP address
     * @return true if the specified IP address is within this network's address space, otherwise false
     */
    @Beta(since = "V1_3_0")
    boolean isPrivateIPAddressInNetwork(String ipAddress);

    /**
     * @return list of address spaces associated with this virtual network, in the CIDR notation
     */
    List<String> addressSpaces();

    /**
     * @return list of DNS server IP addresses associated with this virtual network
     */
    List<String> dnsServerIPs();

    /**
     * @return subnets of this virtual network as a map indexed by subnet name
     *
     * <p>Note that when a virtual network is created with no subnets explicitly defined, a default subnet is
     * automatically created with the name "subnet1".
     */
    Map<String, Subnet> subnets();

    /**
     * @return entry point to managing virtual network peerings for this network
     */
    @Beta(since = "V1_3_0")
    NetworkPeerings peerings();

    /**
     * @return whether DDoS protection is enabled for all the protected resources
     * in the virtual network. It requires a DDoS protection plan associated with the resource.
     */
    boolean isDdosProtectionEnabled();

    /**
     * @return whether VM protection is enabled for all the subnets in the virtual network
     */
    boolean isVmProtectionEnabled();

    /**
     * @return the DDoS protection plan id associated with the virtual network
     */
    String ddosProtectionPlanId();

    /**
     * The entirety of the virtual network definition.
     */
    interface Definition extends
        DefinitionStages.Blank,
        DefinitionStages.WithGroup,
        DefinitionStages.WithSubnet,
        DefinitionStages.WithCreate,
        DefinitionStages.WithCreateAndSubnet {
    }

    /**
     * Grouping of virtual network definition stages.
     */
    interface DefinitionStages {
        /**
         * The first stage of a virtual network definition.
         */
        interface Blank
            extends GroupableResource.DefinitionWithRegion<WithGroup> {
        }

        /**
         * The stage of the virtual network definition allowing to specify the resource group.
         */
        interface WithGroup
            extends GroupableResource.DefinitionStages.WithGroup<DefinitionStages.WithCreate> {
        }

        /**
         * The stage of the virtual network definition allowing to add subnets.
         */
        interface WithSubnet {
            /**
             * Explicitly adds a subnet to the virtual network.
             * <p>
             * If no subnets are explicitly specified, a default subnet called "subnet1" covering the
             * entire first address space will be created.
             * <p>
             * Note this method's effect is additive, i.e. each time it is used, a new subnet is added to the network.
             * @param name the name to assign to the subnet
             * @param cidr the address space of the subnet, within the address space of the network, using the CIDR notation
             * @return the next stage of the definition
             */
            DefinitionStages.WithCreateAndSubnet withSubnet(String name, String cidr);

            /**
             * Explicitly defines subnets in the virtual network based on the provided map.
             * @param nameCidrPairs a {@link Map} of CIDR addresses for the subnets, indexed by the name of each subnet to be defined
             * @return the next stage of the definition
             */
            DefinitionStages.WithCreateAndSubnet withSubnets(Map<String, String> nameCidrPairs);

            /**
             * Begins the definition of a new subnet to add to the virtual network.
             * <p>
             * The definition must be completed with a call to {@link Subnet.DefinitionStages.WithAttach#attach()}
             * @param name the name of the subnet
             * @return the first stage of the new subnet definition
             */
            Subnet.DefinitionStages.Blank<WithCreateAndSubnet> defineSubnet(String name);
        }

        /**
         * The stage of the virtual network definition allowing to specify DDoS protection plan.
         */
        interface WithDdosProtectionPlan {
            /**
             * Creates a new DDoS protection plan in the same region and group as the virtual network and associates it with the resource.
             * The internal name the DDoS protection plan will be derived from the resource's name.
             * @return the next stage of the definition
             */
            @Method
            WithCreateAndSubnet withNewDdosProtectionPlan();

            /**
             * Associates existing DDoS protection plan with the virtual network.
             * @param planId DDoS protection plan resource id
             * @return the next stage of the definition
             */
            WithCreateAndSubnet withExistingDdosProtectionPlan(String planId);
        }

        /**
         * The stage of the virtual network definition allowing to enable VM protection for all the subnets in the virtual network.
         */
        interface WithVmProtection {
            /**
             * Enable VM protection for all the subnets in the virtual network.
             * @return the next stage of the definition
             */
            @Method
            WithCreateAndSubnet withVmProtection();
        }

        /**
         * The stage of the virtual network definition which contains all the minimum required inputs for
         * the resource to be created, but also allows
         * for any other optional settings to be specified, except for adding subnets.
         * <p>
         * Subnets can be added only right after the address space is explicitly specified.
         */
        interface WithCreate extends
            Creatable<Network>,
            Resource.DefinitionWithTags<WithCreate>,
            DefinitionStages.WithDdosProtectionPlan,
            DefinitionStages.WithVmProtection {

            /**
             * Specifies the IP address of an existing DNS server to associate with the virtual network.
             * <p>
             * Note this method's effect is additive, i.e. each time it is used, a new dns server is added
             * to the network.
             * @param ipAddress the IP address of the DNS server
             * @return the next stage of the definition
             */
            WithCreate withDnsServer(String ipAddress);

            /**
             * Explicitly adds an address space to the virtual network.
             * <p>
             * If no address spaces are explicitly specified, a default address space with the CIDR "10.0.0.0/16" will be
             * assigned to the virtual network.
             * <p>
             * Note that this method's effect is additive, i.e. each time it is used, a new address space is added to the network.
             * This method does not check for conflicts or overlaps with other address spaces. If there is a conflict,
             * a cloud exception may be thrown at the time the network is created.
             * @param cidr the CIDR representation of the address space
             * @return the next stage of the definition
             */
            WithCreateAndSubnet withAddressSpace(String cidr);
        }

        /**
         * The stage of the public IP definition which contains all the minimum required inputs for
         * the resource to be created (via {@link WithCreate#create()}), but also allows
         * for any other optional settings to be specified, including adding subnets.
         */
        interface WithCreateAndSubnet extends
            DefinitionStages.WithCreate,
            DefinitionStages.WithSubnet {
        }
    }

    /**
     * Grouping of virtual network update stages.
     */
    interface UpdateStages {
        /**
         * The stage of the virtual network update allowing to add or remove subnets.
         */
        interface WithSubnet {
            /**
             * Explicitly adds a subnet to the virtual network.
             * <p>
             * Note this method's effect is additive, i.e. each time it is used, a new subnet is added to the network.
             * @param name the name to assign to the subnet
             * @param cidr the address space of the subnet, within the address space of the network, using the CIDR notation
             * @return the next stage of the virtual network update
             */
            Update withSubnet(String name, String cidr);

            /**
             * Explicitly defines all the subnets in the virtual network based on the provided map.
             * <p>
             * This replaces any previously existing subnets.
             * @param nameCidrPairs a {@link Map} of CIDR addresses for the subnets, indexed by the name of each subnet to be added
             * @return the next stage of the virtual network update
             */
            Update withSubnets(Map<String, String> nameCidrPairs);

            /**
             * Removes a subnet from the virtual network.
             * @param name name of the subnet to remove
             * @return the next stage of the virtual network update
             */
            Update withoutSubnet(String name);

            /**
             * Begins the description of an update of an existing subnet of this network.
             * @param name the name of an existing subnet
             * @return the first stage of the subnet update description
             */
            Subnet.Update updateSubnet(String name);

            /**
             * Begins the definition of a new subnet to be added to this virtual network.
             * @param name the name of the new subnet
             * @return the first stage of the new subnet definition
             */
            Subnet.UpdateDefinitionStages.Blank<Update> defineSubnet(String name);
        }

        /**
         * The stage of the virtual network update allowing to specify the DNS server.
         */
        interface WithDnsServer {
            /**
             * Specifies the IP address of the DNS server to associate with the virtual network.
             * <p>
             * Note this method's effect is additive, i.e. each time it is used, a new DNS server is
             * added to the network
             * @param ipAddress the IP address of the DNS server
             * @return the next stage of the virtual network update
             */
            Update withDnsServer(String ipAddress);
        }

        /**
         * The stage of the virtual network update allowing to specify the address space.
         */
        interface WithAddressSpace {
            /**
             * Explicitly adds an address space to the virtual network.
             * <p>
             * Note this method's effect is additive, i.e. each time it is used, a new address space is added to the network.
             * <p>
             * This method does not check for conflicts or overlaps with other address spaces. If there is a conflict,
             * a cloud exception may be thrown after the update is applied.
             * @param cidr the CIDR representation of the address space
             * @return the next stage of the update
             */
            Update withAddressSpace(String cidr);

            /**
             * Removes the specified address space from the virtual network, assuming it's not in use bu any of the subnets.
             * @param cidr the address space to remove, in CIDR format, matching exactly one of the CIDRs associated with this network
             * @return the next stage of the update
             */
            @Beta(since = "V1_4_0")
            Update withoutAddressSpace(String cidr);
        }

        /**
         * The stage of the virtual network update allowing to specify DDoS protection plan.
         */
        interface WithDdosProtectionPlan {
            /**
             * Creates a new DDoS protection plan in the same region and group as the virtual network and associates it with the resource.
             * The internal name the DDoS protection plan will be derived from the resource's name.
             * @return the next stage of the update
             */
            @Method
            Update withNewDdosProtectionPlan();

            /**
             * Associates existing DDoS protection plan with the virtual network.
             * @param planId DDoS protection plan resource id
             * @return the next stage of the update
             */
            Update withExistingDdosProtectionPlan(String planId);

            /**
             * Disassociates DDoS protection plan and disables Standard DDoS protection for this virtual network. Note: Plan resource is not deleted from Azure.
             * @return the next stage of the update
             */
            Update withoutDdosProtectionPlan();
        }

        /**
         * The stage of the virtual network update allowing to enable/disable VM protection for all the subnets in the virtual network.
         */
        interface WithVmProtection {
            /**
             * Enable VM protection for all the subnets in the virtual network.
             * @return the next stage of the update
             */
            @Method
            Update withVmProtection();
            /**
             * Disable VM protection for all the subnets in the virtual network.
             * @return the next stage of the update
             */
            @Method
            Update withoutVmProtection();
        }
    }

    /**
     * The template for a virtual network update operation, containing all the settings that
     * can be modified.
     */
    interface Update extends
        Appliable<Network>,
        Resource.UpdateWithTags<Update>,
        UpdateStages.WithSubnet,
        UpdateStages.WithDnsServer,
        UpdateStages.WithAddressSpace,
        UpdateStages.WithDdosProtectionPlan,
        UpdateStages.WithVmProtection {
    }
}
