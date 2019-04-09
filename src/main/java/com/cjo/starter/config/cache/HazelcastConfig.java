package com.cjo.starter.config.cache;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MaxSizeConfig;
import com.hazelcast.config.NetworkConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

@Configuration
public class HazelcastConfig {

	@Value("${hazelcast.port}")
	private Integer port;
	
	@Value("${hazelcast.clustering}")
	private Boolean clusterEnabled;
	
	@Value("${hazelcast.nodes}")
	private String[] nodes;
	
	@Bean
	public Config hazelCastConfig() {
		Config config = new Config();
		config.setInstanceName("hazelcast-instance")
				.addMapConfig(new MapConfig().setName("configuration")
						.setMaxSizeConfig(new MaxSizeConfig(200, MaxSizeConfig.MaxSizePolicy.FREE_HEAP_SIZE))
						.setEvictionPolicy(EvictionPolicy.LRU).setTimeToLiveSeconds(-1));
		
		NetworkConfig network = config.getNetworkConfig();
		network.getJoin().getMulticastConfig().setEnabled(false);
		network.setPort(port);
		
		if (clusterEnabled) {
			for (String node : nodes) {
				network.getJoin().getTcpIpConfig().addMember(node).setEnabled(true);
			}
		}
		
		return config;
	}

	@Bean
	public HazelcastInstance hazelcastInstance() {
		return Hazelcast.newHazelcastInstance(hazelCastConfig());
	}
	
}
