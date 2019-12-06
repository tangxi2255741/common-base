package com.tx.common.exception.monitor;


public class DefaultMonitor implements Monitor {
//	private final CallerInfo mainCaller;
//	private final CallerInfo statisticCaller;
//	private CallerInfo statisticCallerByPlatform;

	protected final String module;
	protected String platform;

	public DefaultMonitor(String module, String platform) {
		this.module = module;

//		mainCaller = registerInfo(UmpConstants.JSF_PROVIDER_BIZ_ROOT + "." + this.module, false, true);
//
//		String statisticKey = JSF_PROVIDER_STATISTICS_ROOT + "." + this.module;
//		statisticCaller = registerInfo(statisticKey, false, true);
//
//		if (StringUtils.hasText(platform)) {
//			this.platform = platform;
//			statisticCallerByPlatform = registerInfo(statisticKey + "." + platform, false, true);
//		}
	}

	@Override
	public void end() {
//		registerInfoEnd(mainCaller);
//		registerInfoEnd(statisticCaller);
//
//		if (statisticCallerByPlatform != null) {
//			registerInfoEnd(statisticCallerByPlatform);
//		}
	}


	@Override
	public void errorCode(String errorCode) {
//		registerInfoEnd(registerInfo(ERRORCODE + errorCode, false, true));
//
//		if (StringUtils.hasText(platform)) {
//			registerInfoEnd(registerInfo(ERRORCODE + errorCode + "." + platform, false, true));
//		}
	}

	@Override
	public void failure() {
//		UmpProfiler.functionError(statisticCaller);
//		if (statisticCallerByPlatform != null) {
//			UmpProfiler.functionError(statisticCallerByPlatform);
//		}
	}

	@Override
	public void functionError() {
//		UmpProfiler.functionError(mainCaller);
	}

	public String getModule() {
		return module;
	}

	public String getPlatform() {
		return platform;
	}
	
	
}
