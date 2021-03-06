package com.wordpress.metaphorm.authProxy.state;

/**
 * Copyright (c) 2014-present Stian Sigvartsen. All rights reserved.
 *
 * This file is part of Social Apps Proxy.
 *
 * Social Apps Proxy is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Social Apps Proxy is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Social Apps Proxy.  If not, see <http://www.gnu.org/licenses/>.
 */

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Stian Sigvartsen
 */
public class OAuthStateManager {

	private static Map<String, OAuthState> sessionMap = new HashMap<String, OAuthState>();
	
	public OAuthStateManager() {
		
	}
	
	public static ManagedOAuthState setOAuthState(String sessionId, OAuthState oAuthState) {
		
		_log.debug("setOAuthState(\"" + sessionId + "\", " + oAuthState.getClass().getName() + ")");
		sessionMap.put(sessionId, oAuthState);
		
		final String stateId = sessionId;
		
		DependencyListener dependencyListener = new DependencyListener() {
			@Override
			public void dependencyExpired() {
				_log.debug("DependencyListener.dependencyExpired() invoked");
				removeOAuthState(stateId);
			}
		};
		oAuthState.registerDependencyListener(dependencyListener);
		
		return new ManagedOAuthState(sessionId, oAuthState);
	}
	
	public static ManagedOAuthState getOAuthState(String sessionId) {
		
		_log.debug("getOAuthState(\"" + sessionId + "\")");
		
		OAuthState oAuthState = sessionMap.get(sessionId);
		if (oAuthState == null) return null;
		
		return new ManagedOAuthState(sessionId, oAuthState);
	}
	
	public static void removeOAuthState(String stateId) {
		
		synchronized (sessionMap) {
			
			if (sessionMap.remove(stateId) != null)
				_log.debug("Removed OAuthState " + stateId);
			else
				_log.debug("OAuthState already removed from OAuthStateManager");
		}
		
	}
	
	public static OAuthState getRelatedOAuthState(String realm, String token) {
		
		Set<String> expiredIds = new HashSet<String>();
		
		// TODO: Consider re-writing this if too much iteration is a problem
		// But then additional objects need to be persisted somehow. Database seems inappropriate
		
		StringBuffer debugMsg = new StringBuffer();
		debugMsg.append("Checking for expired OAuthState objects amongst:");
				for (String stateId : sessionMap.keySet()) {
					debugMsg.append("\n " + stateId);
				}
		_log.debug(debugMsg.toString());
		
		OAuthState foundState = null;
		
		synchronized (sessionMap) {		
		
			for (String stateId : sessionMap.keySet()) {
				
				_log.debug("Checking state: " + stateId);
				
				OAuthState state = sessionMap.get(stateId);
					
				try {
					
					OAuthCredentials oAuthCredentials = state.getOAuthCredentials(realm);
	
					if (oAuthCredentials != null) {
						
						if (oAuthCredentials.getToken() != null && oAuthCredentials.getToken().equals(token)) {
						
							foundState = state;
						}
						
					} else {
						_log.debug("OAuthState " + stateId + " with null consumer for realm " + realm + " encountered. Ignoring.");
					}
	
				} catch (ExpiredStateException e) {
					
					_log.debug("OAuthState " + stateId + " is expired, adding to remove list");
					expiredIds.add(stateId);
					continue;
				}			
			}
		
			_log.debug("Removing expired OAuthState objects...");
			
			int removeCount = 0;
			for (String stateId : expiredIds) {
				
				OAuthState state = sessionMap.get(stateId);
				
				// Invalidate the OAuthState. Ideally this code will never run because active HttpSession lifecycle listening 
				// will have invalidated the OAuthState when the HttpSession expired. However a bug in Liferay 6.1+ means lifecycle listeners are only
				// notified for authenticated sessions!
				state.invalidate();				
				removeCount++;
			}
			
			_log.debug("Removed " + removeCount + " expired OAuthState objects");			
			
		}
		
		return foundState;
	}
	
	public static class ManagedOAuthState implements OAuthState {

		private static final long serialVersionUID = 1L;
		
		private String oAuthStateId;
		private OAuthState oAuthState;
		
		public ManagedOAuthState(String oAuthStateId, OAuthState oAuthState) {
			super();
			this.oAuthStateId = oAuthStateId;
			this.oAuthState = oAuthState;
		}
		
		public String getOAuthStateId() {
			return oAuthStateId;
		}

		public void setOAuthCredentials(String oAuthRealm, OAuthCredentials oAuthCredentials) throws ExpiredStateException {
			oAuthState.setOAuthCredentials(oAuthRealm, oAuthCredentials);
		}

		public OAuthCredentials getOAuthCredentials(String oAuthRealm) throws ExpiredStateException {
			return oAuthState.getOAuthCredentials(oAuthRealm);
		}

		public void setPAuth(String p_auth) throws ExpiredStateException {
			oAuthState.setPAuth(p_auth);
		}

		public String getPAuth() throws ExpiredStateException {
			return oAuthState.getPAuth();
		}

		public void setVerifier(String oAuthRealm, String verifier) throws ExpiredStateException {
			oAuthState.setVerifier(oAuthRealm, verifier);
		}
		
		public String getVerifier(String oAuthRealm) throws ExpiredStateException {
			return oAuthState.getVerifier(oAuthRealm);
		}

		public boolean isExpired() {
			return oAuthState.isExpired();
		}

		public void setPhase(String oAuthRealm, int phase)
				throws ExpiredStateException {
			oAuthState.setPhase(oAuthRealm, phase);
		}

		public int getPhase(String oAuthRealm) throws ExpiredStateException {
			return oAuthState.getPhase(oAuthRealm);
		}
		
		@SuppressWarnings("unchecked")
		public Class<OAuthState> getManagedOAuthState() {
			if (oAuthState instanceof ManagedOAuthState) return ((ManagedOAuthState) oAuthState).getManagedOAuthState();
			return (Class<OAuthState>)oAuthState.getClass();
		}

		public void commitChanges(String oAuthRealm) {
			oAuthState.commitChanges(oAuthRealm);
		}

		@Override
		public void registerDependencyListener(DependencyListener listener) {
			
			oAuthState.registerDependencyListener(listener);
		}

		@Override
		public List<DependencyListener> getDependencyListeners() {
			return oAuthState.getDependencyListeners();
		}

		@Override
		public void invalidate() {
			oAuthState.invalidate();
		}
	}
	
	private static Log _log = LogFactoryUtil.getLog(OAuthStateManager.class);
}