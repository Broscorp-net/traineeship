#!/bin/sh
git fetch origin master:master
changed_files=$(git diff --name-only --diff-filter=ACMRT master | grep -e .class$ -e .iml$ -e .war$ -e .jar$ -e .xml$ -e .lst$ -e .idea| xargs)
if [ -z "$changed_files" ]
then
echo "Trash files not found"
exit 0;
else
  echo " Error: Trash files found!!!! Please delete trash files:"
  echo $changed_files
exit 1;
fi
