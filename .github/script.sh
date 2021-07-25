#!/bin/sh
git fetch origin master:master
changed_files=$(git diff --name-only --diff-filter=ACMRT master | grep .class$ | xargs)
if [ -z "$changed_files" ]
then
echo "Trash files not found"
exit 0;
else
  echo " Error: Trash files found!!!! Please delete trash files, and try again."
exit 1;
fi