#!/bin/bash
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\031[1;33m'
CYAN='\033[1;36m'
NO_COLOR='\033[0m'

echo -e "${YELLOW}Git flow setup script version 1.1${NO_COLOR}"
if [ -e ".git" ]; then
	echo -e "{GREEN}******************************************${NO_COLOR}"
	echo -e "Setting up git flow"
	echo -e ""
	echo -e "${GREEN}*****************************************${NO_COLOR}"
	echo -e "checking branches"
	
	git checkout master
	git checkout production || git checkout -b production
	git checkout master
	echo -e ""
	
	echo -e "{GREEN}******************************************${NO_COLOR}"
	echo -e "Checked branches"
	echo -e "${CYAN}"
	git branch
	echo -e "${NO_COLOR}"
	
	echo -e "{GREEN}******************************************${NO_COLOR}"
	git config --local push.followTags true
	echo -e "Configured push flags:"
	echo -e ""
	git config --get-regexp ^push.*
	echo -e ""
	
	echo -e "{GREEN}******************************************${NO_COLOR}"
	git config --local fetch.prune true
	echo -e "Configured fetch flags:"
	echo -e ""
	git config --get-regexp ^.fetch.*
	echo -e ""
	
	echo -e "{GREEN}******************************************${NO_COLOR}"
	git config --local branch.master.rebase true
	git config --local branch.production.rebase true
	git config --local branch.autosetuprebase always
	echo -e "Configured branch options"
	echo -e ""
	git config --get-regexp ^branch.*
	echo -e
	
	git config --local gitflow.branch.master production
	git config --local gitflow.branch.develop master
	
	git config --local gitflow.prefix.feature feature_
	git config --local gitflow.prefix.bugfix feature_
	git config --local gitflow.prefix.release release_
	git config --local gitflow.prefix.hotfix hotfix_
	git config --local gitflow.prefix.support support_
	git config --local gitflow.prefix.versiontag ''
	git config --local gitflow.path.hooks `pwd`/.git/hooks
	
	echo -e "{GREEN}******************************************${NO_COLOR}"
	echo -e "initialized gitflow"
	echo -e ""
	
	echo -e "{GREEN}******************************************${NO_COLOR}"
	git config --local gitflow.feature.start.fetch true
	git config --local gitflow.feature.finish.fetch true
	git config --local gitflow.feature.finish.no-ff true
	git config --local gitflow.feature.finish.push true
	
	git config --local gitflow.release.start.fetch true
	
	git config --local gitflow.release.finish.fetch true
	git config --local gitflow.release.finish.nobackmerge true
	
	git config --local gitflow.hotfix.finish.fetch true
	git config --local gitflow.hotfix.finish.nobackmerge true
	
	git config --local gitflow.support.start.fetch true
	
	echo -e "Configured flow options"
	echo -e ""
    git config --get-regexp gitflow.*
	echo -e ""
	
	echo -e "{GREEN}******************************************${NO_COLOR}"
	echo -e "Adding aliases for your convinience"
	echo -e "${CYAN}branch-name${NO_COLOR} - get current branch name"
	echo -e "${CYAN}fbr${NO_COLOR} - feature branch rebase(rebases current feature branch to latest master branch comit)"
	git config --local alias.branch-name 'rev-parse --abbrev-ref HEAD'
	git config --local alias.fbr '!f() { b=$(git branch-name); if [[ "$b" == feature* ]]; then echo "Rebasing $b to latest master commit";git checkout master; git pull origin 
	master --rebase; git checkout "$b"; git rebase master; echo "Rebasing done"; else echo "$b" is not a feature branch, nothing to do";fi;}; f'
	echo -e ""
	
	echo -e "{GREEN}******************************************${NO_COLOR}"
	echo -e "initalization done, have a nice day"
	echo -e "${YELLOW}:-)${NO_COLOR}"
	
else
	
	echo -e "${RED}.git folder not found, exiting"
	echo -e "${GREEN}try to run${CYAN}support/git-flow-setup.sh ${GREEN}from root of your project${NO_COLOR}"
	
fi
	
	
	
	
	
	
	
	
	
	
	
	
	
	